package de.mvitz.spring.webmvcinterceptorredirectbug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@Controller
public class SpringBootHandlerInterceptorAdapterRedirectsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHandlerInterceptorAdapterRedirectsApplication.class, args);
    }

    @GetMapping
    public String someMethod() {
        return "redirect:/foo";
    }

    @ResponseBody
    @GetMapping("/foo")
    public String foo() {
        return "foo";
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new HandlerInterceptorAdapter() {
                    @Override
                    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                        if (modelAndView != null) {
                            modelAndView.getModelMap().addAttribute("bar", "baz");
                        }
                    }
                });
            }
        };
    }
}

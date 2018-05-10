package de.mvitz.spring.webmvcinterceptorredirectbug;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SpringBootHandlerInterceptorAdapterRedirectsApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void appendsModelToRedirect() throws Exception {
        mockMvc.perform(get("/")).andExpect(redirectedUrl("/foo"));
    }
}

# Spring WebMVC Interceptor Redirect Bug

Although Spring Boot uses `spring.mvc.ignore-default-model-on-redirect=true` as
default and therefore configures the `RequestMappingHandlerAdapter` with
`ignoreDefaultModelOnRedirect=true` when using a `HandlerInterceptor` which adds
a model attribute in it's `postHandle` method these are appended as query
parameters to the redirect.

## License

spring-webmvcinterceptorredirectbug is Open Source software released under the
[Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0.html).

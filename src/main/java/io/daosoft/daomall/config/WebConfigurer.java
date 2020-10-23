package io.daosoft.daomall.config;

import io.daosoft.daomall.interceptor.AuthenticateInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> guards = Arrays.asList("admin", "shop", "store", "user");

        for (String guard : guards) {
            registry.addInterceptor(getHandlerInterceptor(guard))
                    .addPathPatterns("/" + guard + "/**", "/" + guard)
                    .excludePathPatterns("/" + guard + "/login");
        }
    }

    public static HandlerInterceptor getHandlerInterceptor(String guard) {
        return new AuthenticateInterceptor(guard);
    }
}
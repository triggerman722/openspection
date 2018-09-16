package com.openspection.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.openspection.auth.interceptors.CategoryCountInterceptor;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    CategoryCountInterceptor categoryCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(categoryCountInterceptor).addPathPatterns("/**");
    }
}

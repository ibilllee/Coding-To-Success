package com.scut.cts.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//@Configuration
public class ResourceConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //registry.addResourceHandler("/jportal-jsccbsite/**").addResourceLocations("classpath:/jportal-jsccbsite/");
        //registry.addResourceHandler("/manage/**").addResourceLocations("classpath:/static/manage/");
        //registry.addResourceHandler("/stranded/**").addResourceLocations("classpath:/static/stranded/");
    }
}

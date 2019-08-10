package com.tren.huantai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class MyMvcConfig extends WebMvcConfigurationSupport {
//    @Bean
//    public ViewResolver getViewResolver() {
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.set("/resources/templates/");
//        resolver.ffsetSuffix(".html");
//        resolver.setOrder(1);
//        return resolver;
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/huantai").setViewName("forward:/houseinfo.mainpage?citycode=15566");

    }
}


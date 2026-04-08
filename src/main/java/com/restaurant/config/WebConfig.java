package com.restaurant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
//@ComponentScan(basePackages = "com.restaurant.bai1")
//@ComponentScan(basePackages = "com.restaurant.bai2")
//@ComponentScan(basePackages = "com.restaurant.bai3")
//@ComponentScan(basePackages = "com.restaurant.bai4")
//@ComponentScan(basePackages = "com.restaurant.bai5")
@ComponentScan(basePackages = "com.restaurant.btth")

public class WebConfig {
    @Bean
    InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}

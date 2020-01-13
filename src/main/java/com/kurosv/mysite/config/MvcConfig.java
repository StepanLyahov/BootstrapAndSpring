package com.kurosv.mysite.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    //Как я понял, этот конфиг просто будет возвращать странички по конкрутным url. Как мы и делали в сам в контроллере
    // В нашем случае, когда мы будем пасть login нам будет возврашаеться html login
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/home").setViewName("home");
    }

}

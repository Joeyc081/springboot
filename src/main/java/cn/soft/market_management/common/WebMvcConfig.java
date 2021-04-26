package cn.soft.market_management.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //localhost:8080/imageTest/a/b/c/d/a.jpg
        //D:/imageTest/a/b/c/d/a.jpg
        registry.addResourceHandler("/imageTest/**").addResourceLocations("file:C:/imageTest/");
    }
}
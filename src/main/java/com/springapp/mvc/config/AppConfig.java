package com.springapp.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 04.01.2016
 */
@Configuration
@ComponentScan(basePackages = {
        "com.springapp.mvc.controllers",
        "com.springapp.mvc.services",
        "com.springapp.mvc.repositories"
})
@Import({WebMvcConfig.class, PersistenceConfig.class, SecurityConfig.class, WebSocketConfig.class})
public class AppConfig {

}

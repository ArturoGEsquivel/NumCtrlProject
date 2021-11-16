package com.itss.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * El objetivo de la Class RestInitializer.java es lanzar la configuracion de
 * spring boot.
 * 
 * @author Diana Perez
 * @version 1.0 Fecha de creacion 08/11/2021 10:06:20 AM
 * @since JDK 1.8
 */
@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages  = { "com.itss" })
@EnableJpaRepositories(basePackages = { "com.itss.repository" })
@EntityScan(basePackages = { "com.itss.entity" })
public class ApplicationInitializer {

    /**
     * @param application is the context
     * @return SpringContext
     */
    protected SpringApplicationBuilder configure (SpringApplicationBuilder application) {
        return application.sources(ApplicationInitializer.class);
    }

    /**
     * @param args is the args for the entire application
     */
    public static void main (String[] args) {
        SpringApplication.run(ApplicationInitializer.class, args);
    }

}

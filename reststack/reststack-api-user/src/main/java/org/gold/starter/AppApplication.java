package org.gold.starter;

import org.gold.reststack.filters.HttpFilters;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by wangwr on 2016.3.18.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan({"org.gold.reststack"})
@ImportResource("classpath:spring-context.xml")
public class AppApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HttpFilters.class,
                HttpMessageConverterConfigs.class,
                ContentNegotiationConfigs.class);
    }

    public static void main(String[] args){
        SpringApplication.run(AppApplication.class,args);
    }

}

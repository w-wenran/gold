package gold.starter;

import jp.eisbahn.oauth2.server.spi.servlet.ProtectedResourceFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by wangwr on 2016.3.18.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@ImportResource("classpath:spring-context.xml")
public class AppApplication extends SpringBootServletInitializer {



    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AppApplication.class);
    }

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ProtectedResourceFilter());
        registration.addUrlPatterns("/api/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("someFilter");
        return registration;
    }

    public static void main(String[] args){
        SpringApplication.run(AppApplication.class,args);
    }

}

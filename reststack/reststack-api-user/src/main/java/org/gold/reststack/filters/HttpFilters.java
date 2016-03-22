package org.gold.reststack.filters;

import jp.eisbahn.oauth2.server.spi.servlet.ProtectedResourceFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2016.3.22.
 */
@Configuration
public class HttpFilters {


    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ProtectedResourceFilter());
        registration.addUrlPatterns("/api/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("someFilter");
        return registration;
    }

}

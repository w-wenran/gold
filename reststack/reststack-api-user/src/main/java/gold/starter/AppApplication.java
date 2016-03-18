package gold.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wangwr on 2016.3.18.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class AppApplication {

    public static void main(String[] args){
        SpringApplication.run(AppApplication.class,args);
    }

}

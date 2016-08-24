package fr.exemple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "fr.exemple")
@EnableAutoConfiguration
// @SpringBootApplication
public class AppConfig {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppConfig.class, args);
    }
}

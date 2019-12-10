package de.smartsquare.aoc;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjektApplication {
    public static void main(String[] args){
        SpringApplication.run(ProjektApplication.class, args);
    }

    @Bean
    public CommandLineRunner clr (ApplicationContext ctx) {
        return args -> {
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
        };
    }
}

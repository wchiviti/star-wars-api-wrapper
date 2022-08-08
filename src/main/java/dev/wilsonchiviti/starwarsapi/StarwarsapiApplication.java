package dev.wilsonchiviti.starwarsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StarwarsapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarwarsapiApplication.class, args);
    }

}

package ie.atu.cicdproject.ffmainapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FfMainApp {
    public static void main(String[] args) {
        SpringApplication.run(FfMainApp.class, args);
    }
}

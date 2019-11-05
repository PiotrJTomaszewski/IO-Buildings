package pl.put.poznan.buildings.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.buildings.rest"})
public class BuildingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildingsApplication.class, args);
    }
}

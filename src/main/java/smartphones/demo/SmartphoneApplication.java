package smartphones.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import smartphones.demo.repository.PhoneRepository;

@SpringBootApplication
public class SmartphoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartphoneApplication.class, args);
    }


}

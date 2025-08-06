package springboot_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp4 {
    public static void main(String[] args) {
        SpringApplication.run(MainApp4.class, args);
    }
}


//http://localhost:8080/users/101/accounts?type=current&status=active
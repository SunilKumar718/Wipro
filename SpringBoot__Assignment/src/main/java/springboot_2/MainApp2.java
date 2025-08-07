package springboot_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp2 implements CommandLineRunner {

    @Autowired
    private Properties propertyInjectionExample;

    public static void main(String[] args) {
        SpringApplication.run(MainApp2.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        propertyInjectionExample.printValues();
    }
}

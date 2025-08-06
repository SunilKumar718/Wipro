package springboot_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp1 implements CommandLineRunner{

    @Autowired
    ClassKLM klm;

    public static void main(String[] args) {
        SpringApplication.run(MainApp1.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        klm.show();
    }
}

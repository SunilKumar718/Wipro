package restaurantConsumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerMainApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMainApp.class, args);
    }
}

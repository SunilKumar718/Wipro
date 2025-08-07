package delivery;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeliveryService {

    private final RestTemplate restTemplate = new RestTemplate();

    @CircuitBreaker(name = "deliveryService", fallbackMethod = "getFallbackStatus")
    public String getDeliveryStatus() {
        return restTemplate.getForObject("http://localhost:8081/delivery/status", String.class);
    }

    public String getFallbackStatus(Throwable t) {
        return "Delivery service is currently unavailable. Please try again Later.";
    }
}
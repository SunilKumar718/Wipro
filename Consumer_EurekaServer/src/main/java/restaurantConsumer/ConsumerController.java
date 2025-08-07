package restaurantConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {

    @Autowired
    private RestaurantClient restaurantClient;

    @GetMapping("/consumer/restaurants")
    public List<Restaurant> getAllRestaurants() {
        return restaurantClient.getRestaurants();
    }
}

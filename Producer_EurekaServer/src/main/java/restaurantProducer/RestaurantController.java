package restaurantProducer;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RestaurantController {

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        return Arrays.asList(
            new Restaurant(1, "Taj", "Hyderabad"),
            new Restaurant(2, "BBQ", "Bangalore"),
            new Restaurant(3, "Mehfil", "Chennai")
        );
    }
}

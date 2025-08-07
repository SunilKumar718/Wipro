package springboot_14;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepo;

    @Autowired
    private FoodRepository foodRepo;

    @PostMapping
    public Restaurant createRestaurant(@Valid @RequestBody Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants(){
        return restaurantRepo.findAll();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable int id) {
        return restaurantRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public String deleteRestaurant(@PathVariable int id) {
        if (!restaurantRepo.existsById(id)) {
            throw new ResourceNotFoundException("Restaurant not found with id: " + id);
        }
        restaurantRepo.deleteById(id);
        return "Deleted successfully.";
    }

    @PostMapping("/{id}/food")
    public Food addFoodToRestaurant(@PathVariable int id, @Valid @RequestBody Food food) {
        Restaurant restaurant = restaurantRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id));
        food.setRestaurant(restaurant);
        return foodRepo.save(food);
    }
    

    @DeleteMapping("/foods/{foodId}")
    public String deleteFood(@PathVariable int foodId) {
        if (!foodRepo.existsById(foodId)) {
            throw new ResourceNotFoundException("Food not found with id: " + foodId);
        }
        foodRepo.deleteById(foodId);
        return "Food deleted successfully.";
    }
}

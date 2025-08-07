package grocery;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grocery")
public class GroceryController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Welcome to the Grocery Store!";
    }

    @GetMapping("/items")
    public List<String> getItems() {
        return List.of("Milk", "Bread", "Eggs", "Rice");
    }

    @GetMapping("/orders")
    public List<String> getOrders() {
        return List.of("Order#123", "Order#456", "Order#789");
    }

    @GetMapping("/admin/only")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminOnly() {
        return "Only accessible to ADMIN users!";
    }
}

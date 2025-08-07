package springboot_8;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController{

    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        return "Received user: " + user.getFirstName() + " " + user.getLastName() + ", age: " + user.getAge();
    }
}

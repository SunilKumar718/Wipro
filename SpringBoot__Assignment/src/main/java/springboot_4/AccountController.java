package springboot_4;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class AccountController{

    @GetMapping("/users/{id}/accounts")
    public List<String> getAccounts(
            @PathVariable String id,
            @RequestParam String type,
            @RequestParam String status
    ) {
        List<String> accounts = new ArrayList<>();
        accounts.add("User ID: "+id);
        accounts.add("Account Type: "+type);
        accounts.add("Status: "+status);
        return accounts;
    }
}

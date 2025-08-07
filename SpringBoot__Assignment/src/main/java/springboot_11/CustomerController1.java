package springboot_11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController1 {

    @GetMapping("/springrest/customers")
    public List<Customer1> getCustomers() {
        return Arrays.asList(
            new Customer1(105, "John", "Smith", "jdoe@gmail.com", "1970235678", 167240235L),
            new Customer1(301, "Michael", "Steve", "steve@gmail.com", "12345986", 1467240235069L),
            new Customer1(303, "katey", "Williams", "kwilliams@gmail.com", "78903221", 1467240235069L)
        );
    }
}

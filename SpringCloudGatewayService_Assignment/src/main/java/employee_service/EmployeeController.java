package employee_service;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/details")
    public String getEmployeeInfo() {
        return "Employee Details - Gateway Reached Me!";
    }
}

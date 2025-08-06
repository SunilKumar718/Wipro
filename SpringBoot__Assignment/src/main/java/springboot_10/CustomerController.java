package springboot_10;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @GetMapping("/cust/save")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "CustomerForm";
    }

    @PostMapping("/cust/save")
    public String submitForm(@Valid @ModelAttribute("customer") Customer customer,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "CustomerForm";
        }
        return "CustomerSuccess";
    }
}

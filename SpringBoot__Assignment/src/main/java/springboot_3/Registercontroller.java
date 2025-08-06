package springboot_3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Registercontroller{
	
	
//	 @GetMapping("/")
//	    public String redirectToRegister() {
//	        return "redirect:/register";
//	    }


    @GetMapping("/register")
    public String showForm() {
        return "register";  
    }

    @PostMapping("/submit")
    @ResponseBody
    public String handleForm(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String birthday,
            @RequestParam String profession
    ) {
        return "<h3>Submitted Details:</h3>" +
               "Username: " + username + "<br/>" +
               "Password: " + password + "<br/>" +
               "Email: " + email + "<br/>" +
               "Birthday: " + birthday + "<br/>" +
               "Profession: " + profession;
    }
}

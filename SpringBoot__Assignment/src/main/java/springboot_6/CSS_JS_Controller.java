package springboot_6;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CSS_JS_Controller {

    @GetMapping("/home")
    public String home() {
        return "Demo";  
    }
}

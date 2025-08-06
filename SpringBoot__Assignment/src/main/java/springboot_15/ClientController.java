package springboot_15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;

@Controller
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("listClients", service.getAll());
        return "ClientDetails";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("client", new Client());
        return "ClientForm";
    }

    @PostMapping("/save")
    public String saveClient(@Valid @ModelAttribute("client") Client client, BindingResult result) {
        if (result.hasErrors()) return "ClientForm";
        service.save(client);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Client client = service.get(id);
        model.addAttribute("client", client);
        return "ClientForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}

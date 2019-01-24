package lu.ing.web.controller;

import lu.ing.web.api.ServiceClient;
import lu.ing.web.model.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Spring-MVC servlet.
 */
@Controller
public class HomeController {

    @Autowired
    private ServiceClient serviceClient;

    @GetMapping("/")
    public String index(Model model) {

        // call remote API
        List<ClientDto> clients = serviceClient.getClients();

        // populate MVC model
        model.addAttribute("clients", clients);

        // call 'thymeleaf' template: resources/templates/index.html
        return "index";
    }
}

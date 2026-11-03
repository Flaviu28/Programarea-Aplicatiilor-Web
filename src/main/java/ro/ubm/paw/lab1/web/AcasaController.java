package ro.ubm.paw.lab1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AcasaController {

    @GetMapping("/")
    public String acasa() {
        return "redirect:/produse";
    }
}

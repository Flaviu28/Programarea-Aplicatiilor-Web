package ro.ubm.paw.lab1.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.ubm.paw.lab1.service.OrderService;

@RestController
public class HelloController {
    private final String numeAplicatie;
    private final OrderService orderService;

    public HelloController(@Value("${app.nume}") String numeAplicatie,
                           OrderService orderService) {
        this.numeAplicatie = numeAplicatie;
        this.orderService = orderService;
    }

    @GetMapping("/salut")
    public String index() {
        return "Salut din " + numeAplicatie + "!";
    }

    @GetMapping("/comanda")
    public String comanda(@RequestParam String client,
                          @RequestParam(defaultValue = "false") boolean urgenta) {
        return orderService.plaseazaComanda(client, urgenta);
    }
}

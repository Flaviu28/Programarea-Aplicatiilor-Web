package ro.ubm.paw.lab1.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ro.ubm.paw.lab1.model.Produs;
import ro.ubm.paw.lab1.service.CatalogService;

@Controller
@RequestMapping("/produse")
public class ProdusController {

    private final CatalogService catalog;

    public ProdusController(CatalogService catalog) {
        this.catalog = catalog;
    }

    @GetMapping
    public String lista(@RequestParam(required = false) Long categorieId,
                        @RequestParam(required = false) String q,
                        Model model) {
        model.addAttribute("produse", catalog.cautaProduse(categorieId, q));
        model.addAttribute("categorii", catalog.toateCategoriile());
        model.addAttribute("categorieSelectata", categorieId);
        model.addAttribute("q", q);
        return "produse/lista";
    }

    @GetMapping("/nou")
    public String formularNou(Model model) {
        model.addAttribute("produs", new ProdusForm());
        model.addAttribute("categorii", catalog.toateCategoriile());
        return "produse/formular";
    }

    @GetMapping("/{id}/editare")
    public String formularEditare(@PathVariable Long id, Model model) {
        model.addAttribute("produs", catalog.formularPentru(id));
        model.addAttribute("categorii", catalog.toateCategoriile());
        return "produse/formular";
    }

    @PostMapping
    public String salveaza(@Valid @ModelAttribute("produs") ProdusForm form,
                           BindingResult erori,
                           Model model,
                           RedirectAttributes redirect) {
        if (erori.hasErrors()) {
            model.addAttribute("categorii", catalog.toateCategoriile());
            return "produse/formular";
        }
        boolean nou = form.getId() == null;
        Produs salvat = catalog.salveaza(form);
        redirect.addFlashAttribute("mesaj",
                (nou ? "Produs adăugat: " : "Produs actualizat: ") + salvat.getNume());
        return "redirect:/produse";
    }

    @PostMapping("/{id}/stergere")
    public String sterge(@PathVariable Long id, RedirectAttributes redirect) {
        catalog.stergeProdus(id);
        redirect.addFlashAttribute("mesaj", "Produsul a fost șters");
        return "redirect:/produse";
    }
}

package ro.ubm.paw.lab1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ro.ubm.paw.lab1.model.Categorie;
import ro.ubm.paw.lab1.model.Produs;
import ro.ubm.paw.lab1.repository.CategorieRepository;
import ro.ubm.paw.lab1.repository.ProdusRepository;
import ro.ubm.paw.lab1.web.ProdusForm;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CatalogService {

    private final ProdusRepository produse;
    private final CategorieRepository categorii;

    public CatalogService(ProdusRepository produse, CategorieRepository categorii) {
        this.produse = produse;
        this.categorii = categorii;
    }

    public List<Produs> cautaProduse(Long categorieId, String text) {
        if (StringUtils.hasText(text)) {
            return produse.findByNumeContainingIgnoreCaseOrderByNumeAsc(text.trim());
        }
        if (categorieId != null) {
            return produse.findByCategorieIdOrderByNumeAsc(categorieId);
        }
        return produse.findAllByOrderByNumeAsc();
    }

    public Produs gasesteProdus(Long id) {
        return produse.findWithCategorieById(id)
                .orElseThrow(() -> new ResursaNegasitaException("Produsul " + id + " nu există"));
    }

    public List<Categorie> toateCategoriile() {
        return categorii.findAllByOrderByNumeAsc();
    }

    @Transactional
    public Produs salveaza(ProdusForm form) {
        Categorie categorie = categorii.findById(form.getCategorieId())
                .orElseThrow(() -> new ResursaNegasitaException("Categoria nu există"));

        if (form.getId() == null) {
            return produse.save(new Produs(
                    form.getNume().trim(),
                    form.getDescriere(),
                    form.getPret(),
                    form.getStoc(),
                    categorie
            ));
        }

        Produs existent = gasesteProdus(form.getId());
        existent.setNume(form.getNume().trim());
        existent.setDescriere(form.getDescriere());
        existent.setPret(form.getPret());
        existent.setStoc(form.getStoc());
        existent.setCategorie(categorie);
        return existent;
    }

    @Transactional
    public void stergeProdus(Long id) {
        produse.delete(gasesteProdus(id));
    }

    public ProdusForm formularPentru(Long id) {
        Produs p = gasesteProdus(id);
        ProdusForm f = new ProdusForm();
        f.setId(p.getId());
        f.setNume(p.getNume());
        f.setDescriere(p.getDescriere());
        f.setPret(p.getPret());
        f.setStoc(p.getStoc());
        f.setCategorieId(p.getCategorie().getId());
        return f;
    }
}

package ro.ubm.paw.lab1.web;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class ProdusForm {

    private Long id;

    @NotBlank(message = "Numele este obligatoriu")
    @Size(max = 150, message = "Numele are cel mult 150 de caractere")
    private String nume;

    @Size(max = 1000, message = "Descrierea are cel mult 1000 de caractere")
    private String descriere;

    @NotNull(message = "Prețul este obligatoriu")
    @DecimalMin(value = "0.01", message = "Prețul trebuie să fie pozitiv")
    @Digits(integer = 8, fraction = 2, message = "Cel mult 8 cifre și 2 zecimale")
    private BigDecimal pret;

    @NotNull(message = "Stocul este obligatoriu")
    @Min(value = 0, message = "Stocul nu poate fi negativ")
    private Integer stoc;

    @NotNull(message = "Alegeți o categorie")
    private Long categorieId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public String getDescriere() { return descriere; }
    public void setDescriere(String descriere) { this.descriere = descriere; }
    public BigDecimal getPret() { return pret; }
    public void setPret(BigDecimal pret) { this.pret = pret; }
    public Integer getStoc() { return stoc; }
    public void setStoc(Integer stoc) { this.stoc = stoc; }
    public Long getCategorieId() { return categorieId; }
    public void setCategorieId(Long categorieId) { this.categorieId = categorieId; }
}

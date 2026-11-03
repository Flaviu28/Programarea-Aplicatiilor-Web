package ro.ubm.paw.lab1.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String nume;

    @Column(length = 500)
    private String descriere;

    @OneToMany(mappedBy = "categorie")
    private List<Produs> produse = new ArrayList<>();

    protected Categorie() {}

    public Categorie(String nume, String descriere) {
        this.nume = nume;
        this.descriere = descriere;
    }

    public Long getId() { return id; }
    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public String getDescriere() { return descriere; }
    public void setDescriere(String descriere) { this.descriere = descriere; }
    public List<Produs> getProduse() { return produse; }
}

package ro.ubm.paw.lab1.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "produs")
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nume;

    @Column(length = 1000)
    private String descriere;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal pret;

    @Column(nullable = false)
    private int stoc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @Column(name = "creat_la", nullable = false, updatable = false)
    private LocalDateTime creatLa;

    protected Produs() {}

    public Produs(String nume, String descriere, BigDecimal pret, int stoc, Categorie categorie) {
        this.nume = nume;
        this.descriere = descriere;
        this.pret = pret;
        this.stoc = stoc;
        this.categorie = categorie;
    }

    @PrePersist
    void laCreare() {
        creatLa = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public String getDescriere() { return descriere; }
    public void setDescriere(String descriere) { this.descriere = descriere; }
    public BigDecimal getPret() { return pret; }
    public void setPret(BigDecimal pret) { this.pret = pret; }
    public int getStoc() { return stoc; }
    public void setStoc(int stoc) { this.stoc = stoc; }
    public Categorie getCategorie() { return categorie; }
    public void setCategorie(Categorie categorie) { this.categorie = categorie; }
    public LocalDateTime getCreatLa() { return creatLa; }
}

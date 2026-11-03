package ro.ubm.paw.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubm.paw.lab1.model.Categorie;
import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    List<Categorie> findAllByOrderByNumeAsc();
}

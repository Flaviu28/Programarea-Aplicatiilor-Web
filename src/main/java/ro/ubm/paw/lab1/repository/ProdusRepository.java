package ro.ubm.paw.lab1.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubm.paw.lab1.model.Produs;

import java.util.List;
import java.util.Optional;

public interface ProdusRepository extends JpaRepository<Produs, Long> {

    @EntityGraph(attributePaths = "categorie")
    List<Produs> findAllByOrderByNumeAsc();

    @EntityGraph(attributePaths = "categorie")
    List<Produs> findByCategorieIdOrderByNumeAsc(Long categorieId);

    @EntityGraph(attributePaths = "categorie")
    List<Produs> findByNumeContainingIgnoreCaseOrderByNumeAsc(String text);

    @EntityGraph(attributePaths = "categorie")
    Optional<Produs> findWithCategorieById(Long id);
}

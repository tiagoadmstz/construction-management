package io.github.tiagoadmstz.cm.repositories;

import io.github.tiagoadmstz.cm.entities.PublicConstruction;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicConstructionRepository extends JpaRepository<PublicConstruction, Long> {

    @Query("FROM PublicConstruction a JOIN FETCH a.construction.owners b WHERE b.id = :id")
    Optional<List<PublicConstruction>> findAllByOwnerId(Long id);

}

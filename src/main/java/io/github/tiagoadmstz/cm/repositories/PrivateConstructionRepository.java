package io.github.tiagoadmstz.cm.repositories;

import io.github.tiagoadmstz.cm.entities.PrivateConstruction;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateConstructionRepository extends JpaRepository<PrivateConstruction, Long> {

    @Query("FROM PrivateConstruction a JOIN FETCH a.construction.owners b WHERE b.id = :id")
    Optional<List<PrivateConstruction>> findAllByOwnerId(Long id);

}

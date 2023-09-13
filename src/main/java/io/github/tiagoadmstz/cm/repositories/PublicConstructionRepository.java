package io.github.tiagoadmstz.cm.repositories;

import io.github.tiagoadmstz.cm.entities.PublicConstruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicConstructionRepository extends JpaRepository<PublicConstruction, Long> {
}

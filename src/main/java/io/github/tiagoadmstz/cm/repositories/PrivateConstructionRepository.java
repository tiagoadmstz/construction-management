package io.github.tiagoadmstz.cm.repositories;

import io.github.tiagoadmstz.cm.entities.PrivateConstruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateConstructionRepository extends JpaRepository<PrivateConstruction, Long> {
}

package io.github.tiagoadmstz.cm.repositories;

import io.github.tiagoadmstz.cm.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}

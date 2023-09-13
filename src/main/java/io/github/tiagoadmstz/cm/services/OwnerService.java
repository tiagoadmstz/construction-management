package io.github.tiagoadmstz.cm.services;

import io.github.tiagoadmstz.cm.entities.Owner;
import io.github.tiagoadmstz.cm.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    private final OwnerRepository repository;

    public OwnerService(OwnerRepository repository) {
        this.repository = repository;
    }

    public Owner save(Owner owner) {
        return repository.save(owner);
    }
}

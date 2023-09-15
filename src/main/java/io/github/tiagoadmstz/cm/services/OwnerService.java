package io.github.tiagoadmstz.cm.services;

import io.github.tiagoadmstz.cm.dtos.OwnerDto;
import io.github.tiagoadmstz.cm.entities.Owner;
import io.github.tiagoadmstz.cm.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    private final OwnerRepository repository;

    public OwnerService(OwnerRepository repository) {
        this.repository = repository;
    }

    public OwnerDto save(OwnerDto ownerDto) {
        final Owner owner = new Owner(ownerDto);
        return new OwnerDto(repository.save(owner));
    }

    public void refreshOwners(Owner owner) {
        repository.findById(owner.getId())
                .ifPresent(result -> {
                    owner.setCpf(result.getCpf());
                    owner.setName(result.getName());
                });
    }
}

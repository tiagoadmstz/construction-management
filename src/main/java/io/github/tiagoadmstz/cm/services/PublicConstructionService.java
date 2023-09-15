package io.github.tiagoadmstz.cm.services;

import io.github.tiagoadmstz.cm.repositories.PublicConstructionRepository;
import org.springframework.stereotype.Service;

@Service
public class PublicConstructionService {

    private PublicConstructionRepository repository;

    public PublicConstructionService(PublicConstructionRepository repository) {
        this.repository = repository;
    }
}

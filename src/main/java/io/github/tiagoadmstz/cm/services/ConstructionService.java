package io.github.tiagoadmstz.cm.services;

import io.github.tiagoadmstz.cm.entities.Construction;
import io.github.tiagoadmstz.cm.entities.PrivateConstruction;
import io.github.tiagoadmstz.cm.entities.PublicConstruction;
import io.github.tiagoadmstz.cm.repositories.PrivateConstructionRepository;
import io.github.tiagoadmstz.cm.repositories.PublicConstructionRepository;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ConstructionService {

    private final PublicConstructionRepository publicConstructionRepository;
    private final PrivateConstructionRepository privateConstructionRepository;

    public ConstructionService(
            PublicConstructionRepository publicConstructionRepository,
            PrivateConstructionRepository privateConstructionRepository
    ) {
        this.publicConstructionRepository = publicConstructionRepository;
        this.privateConstructionRepository = privateConstructionRepository;
    }

    public List<Construction> findAllConstructions() {
        return Collections.emptyList();
    }

    public List<Construction> findAllConstructionsByOwnerCode(Long id) {
        return Collections.emptyList();
    }

    public List<PublicConstruction> findAllPublicConstructions() {
        return publicConstructionRepository.findAll();
    }

    public List<PrivateConstruction> findAllPrivateConstructions() {
        return privateConstructionRepository.findAll();
    }

    public PublicConstruction createPublicConstruction(PublicConstruction publicConstruction) {
        return publicConstructionRepository.save(publicConstruction);
    }

    public PrivateConstruction createPrivateConstruction(PrivateConstruction privateConstruction) {
        return privateConstructionRepository.save(privateConstruction);
    }
}

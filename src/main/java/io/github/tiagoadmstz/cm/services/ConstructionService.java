package io.github.tiagoadmstz.cm.services;

import io.github.tiagoadmstz.cm.dtos.ConstructionDto;
import io.github.tiagoadmstz.cm.dtos.PrivateConstructionDto;
import io.github.tiagoadmstz.cm.dtos.PublicConstructionDto;
import io.github.tiagoadmstz.cm.entities.Owner;
import io.github.tiagoadmstz.cm.entities.PrivateConstruction;
import io.github.tiagoadmstz.cm.entities.PublicConstruction;
import io.github.tiagoadmstz.cm.repositories.PrivateConstructionRepository;
import io.github.tiagoadmstz.cm.repositories.PublicConstructionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ConstructionService {

    private final OwnerService ownerService;
    private final PublicConstructionRepository publicConstructionRepository;
    private final PrivateConstructionRepository privateConstructionRepository;

    public ConstructionService(
            OwnerService ownerService,
            PublicConstructionRepository publicConstructionRepository,
            PrivateConstructionRepository privateConstructionRepository
    ) {
        this.ownerService = ownerService;
        this.publicConstructionRepository = publicConstructionRepository;
        this.privateConstructionRepository = privateConstructionRepository;
    }

    public List<ConstructionDto> findAllConstructions() {
        final List<ConstructionDto> constructionList = new ArrayList<>(1);
        final List<PublicConstruction> publicConstructions = publicConstructionRepository.findAll();
        final List<PrivateConstruction> privateConstructions = privateConstructionRepository.findAll();
        constructionList.addAll(publicConstructions.stream().map(ConstructionDto::new).toList());
        constructionList.addAll(privateConstructions.stream().map(ConstructionDto::new).toList());
        return constructionList;
    }

    public List<ConstructionDto> findAllConstructionsByOwnerCode(Long id) {
        final List<ConstructionDto> constructionList = new ArrayList<>(1);
        final Optional<List<PublicConstruction>> publicConstructions = publicConstructionRepository.findAllByOwnerId(id);
        publicConstructions.ifPresent(list -> {
            final List<ConstructionDto> dtoList = list.stream().map(ConstructionDto::new).toList();
            constructionList.addAll(dtoList);
        });
        final Optional<List<PrivateConstruction>> privateConstructions = privateConstructionRepository.findAllByOwnerId(id);
        privateConstructions.ifPresent(list -> {
            final List<ConstructionDto> dtoList = list.stream().map(ConstructionDto::new).toList();
            constructionList.addAll(dtoList);
        });
        return constructionList;
    }

    public List<ConstructionDto> findAllPublicConstructions() {
        final List<PublicConstruction> publicConstructions = publicConstructionRepository.findAll();
        return publicConstructions.stream().map(ConstructionDto::new).toList();
    }

    public List<ConstructionDto> findAllPrivateConstructions() {
        final List<PrivateConstruction> privateConstructions = privateConstructionRepository.findAll();
        return privateConstructions.stream().map(ConstructionDto::new).toList();
    }

    public PublicConstructionDto createPublicConstruction(PublicConstructionDto publicConstructionDto) {
        final PublicConstruction publicConstruction = new PublicConstruction(publicConstructionDto);
        final PublicConstruction savedConstruction = publicConstructionRepository.save(publicConstruction);
        refreshOwners(savedConstruction.getConstruction().getOwners());
        return new PublicConstructionDto(savedConstruction);
    }

    public PrivateConstructionDto createPrivateConstruction(PrivateConstructionDto privateConstructionDto) {
        final PrivateConstruction privateConstruction = new PrivateConstruction(privateConstructionDto);
        final PrivateConstruction savedConstruction = privateConstructionRepository.save(privateConstruction);
        refreshOwners(savedConstruction.getConstruction().getOwners());
        return new PrivateConstructionDto(savedConstruction);
    }

    private void refreshOwners(List<Owner> owners) {
        owners.forEach(ownerService::refreshOwners);
    }
}

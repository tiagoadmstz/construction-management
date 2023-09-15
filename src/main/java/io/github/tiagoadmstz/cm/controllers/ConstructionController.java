package io.github.tiagoadmstz.cm.controllers;

import io.github.tiagoadmstz.cm.dtos.ConstructionDto;
import io.github.tiagoadmstz.cm.dtos.PrivateConstructionDto;
import io.github.tiagoadmstz.cm.dtos.PublicConstructionDto;
import io.github.tiagoadmstz.cm.entities.Construction;
import io.github.tiagoadmstz.cm.entities.PrivateConstruction;
import io.github.tiagoadmstz.cm.entities.PublicConstruction;
import io.github.tiagoadmstz.cm.services.ConstructionService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConstructionController {

    private final ConstructionService constructionService;

    public ConstructionController(ConstructionService constructionService) {
        this.constructionService = constructionService;
    }

    @GetMapping("/obras")
    public ResponseEntity<List<ConstructionDto>> findAllConstructions() {
        return ResponseEntity.ok(constructionService.findAllConstructions());
    }

    @GetMapping("/obras/{ownercode}")
    public ResponseEntity<List<ConstructionDto>> findAllConstructionsByOwnerCode(@PathVariable("ownercode") Long id) {
        return ResponseEntity.ok(constructionService.findAllConstructionsByOwnerCode(id));
    }

    @GetMapping("/obras/public")
    public ResponseEntity<List<ConstructionDto>> findAllPublicConstructions() {
        return ResponseEntity.ok(constructionService.findAllPublicConstructions());
    }

    @GetMapping("/obras/private")
    public ResponseEntity<List<ConstructionDto>> findAllPrivateConstructions() {
        return ResponseEntity.ok(constructionService.findAllPrivateConstructions());
    }

    @PostMapping("/obrapublica")
    public ResponseEntity<PublicConstructionDto> createPublicConstruction(@RequestBody PublicConstructionDto publicConstructionDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(constructionService.createPublicConstruction(publicConstructionDto));
    }

    @PostMapping("/obraprivada")
    public ResponseEntity<PrivateConstructionDto> createPrivateConstruction(@RequestBody PrivateConstructionDto privateConstructionDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(constructionService.createPrivateConstruction(privateConstructionDto));
    }

}

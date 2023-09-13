package io.github.tiagoadmstz.cm.controllers;

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
    public ResponseEntity<List<Construction>> findAllConstructions() {
        return ResponseEntity.ok(constructionService.findAllConstructions());
    }

    @GetMapping("/obras/{ownercode}")
    public ResponseEntity<List<Construction>> findAllConstructionsByOwnerCode(@PathVariable("ownercode") Long id) {
        return ResponseEntity.ok(constructionService.findAllConstructionsByOwnerCode(id));
    }

    @GetMapping("/obras/public")
    public ResponseEntity<List<PublicConstruction>> findAllPublicConstructions() {
        return ResponseEntity.ok(constructionService.findAllPublicConstructions());
    }

    @GetMapping("/obras/private")
    public ResponseEntity<List<PrivateConstruction>> findAllPrivateConstructions() {
        return ResponseEntity.ok(constructionService.findAllPrivateConstructions());
    }

    @PostMapping("/obrapublica")
    public ResponseEntity<PublicConstruction> createPublicConstruction(@RequestBody PublicConstruction publicConstruction) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(constructionService.createPublicConstruction(publicConstruction));
    }

    @PostMapping("/obraprivada")
    public ResponseEntity<PrivateConstruction> createPrivateConstruction(@RequestBody PrivateConstruction privateConstruction) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(constructionService.createPrivateConstruction(privateConstruction));
    }

}

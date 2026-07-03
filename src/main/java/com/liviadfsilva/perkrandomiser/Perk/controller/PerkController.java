package com.liviadfsilva.perkrandomiser.Perk.controller;

import com.liviadfsilva.perkrandomiser.Perk.dto.PerkRequest;
import com.liviadfsilva.perkrandomiser.Perk.model.Perk;
import com.liviadfsilva.perkrandomiser.Perk.service.PerkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perks")
public class PerkController {
    private final PerkService service;

    private PerkController(PerkService service){
        this.service = service;
    }

    @GetMapping
    public List<Perk> getAllPerks(){
        return service.getAllPerks();
    }

    @GetMapping("/{id}")
    public Perk getPerkById(@PathVariable Long id) {
        return service.getPerkById(id)
                .orElseThrow(() -> new RuntimeException("Perk not found."));
    }

    @PostMapping
    public ResponseEntity<Perk> createPerk(@RequestBody PerkRequest request) {
        Perk perk = service.createPerk(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(perk);
    }

    @PatchMapping("/{id}")
    public Perk updatePerk(@PathVariable Long id, @RequestBody PerkRequest request) {
        return service.updatePerk(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletePerk(@PathVariable Long id) {
        service.deletePerk(id);
    }
}
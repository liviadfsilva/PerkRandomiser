package com.liviadfsilva.perkrandomiser.Perk.controller;

import com.liviadfsilva.perkrandomiser.Perk.model.Perk;
import com.liviadfsilva.perkrandomiser.Perk.service.PerkService;
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
    public Perk createPerk(@RequestBody Perk perk) {
        return service.createTask(perk);
    }

    @PutMapping("/{id}")
    public Perk updatePerk(@PathVariable Long id, @RequestBody Perk perk) {
        return service.updatePerk(id, perk);
    }

    @DeleteMapping("/{id}")
    public void deletePerk(@PathVariable Long id) {
        service.deletePerk(id);
    }
}
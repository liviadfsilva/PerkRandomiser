package com.liviadfsilva.perkrandomiser.Perk.service;

import com.liviadfsilva.perkrandomiser.Perk.model.Perk;
import com.liviadfsilva.perkrandomiser.Perk.repository.PerkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerkService {

    private final PerkRepository repository;

    public PerkService(PerkRepository repository) {
        this.repository = repository;
    }

    public List<Perk> getAllTasks() {
        return repository.findAll();
    }

    public Optional<Perk> getPerkById(Long id) {
        return repository.findById(id);
    }

    public Perk createTask(Perk perk) {
        return repository.save(perk);
    }

    public Perk updatePerk(Long id, Perk perkDetails){
        Perk perk = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perk not found."));
        perk.setName(perkDetails.getName());
        perk.setRole(perkDetails.getRole());
        return repository.save(perk);
    }
    
    public void deletePerk(Long id) {
        repository.deleteById(id);
    }
}

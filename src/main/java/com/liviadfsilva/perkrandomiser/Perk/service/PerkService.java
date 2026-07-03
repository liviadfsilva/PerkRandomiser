package com.liviadfsilva.perkrandomiser.Perk.service;

import com.liviadfsilva.perkrandomiser.Category.model.Category;
import com.liviadfsilva.perkrandomiser.Category.repository.CategoryRepository;
import com.liviadfsilva.perkrandomiser.Perk.dto.PerkRequest;
import com.liviadfsilva.perkrandomiser.Perk.model.Perk;
import com.liviadfsilva.perkrandomiser.Perk.repository.PerkRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PerkService {

    private final PerkRepository perkRepository;
    private final CategoryRepository categoryRepository;

    public PerkService(PerkRepository perkRepository, CategoryRepository categoryRepository) {
        this.perkRepository = perkRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Perk> getAllPerks() {
        return perkRepository.findAll();
    }

    public Optional<Perk> getPerkById(Long id) {
        return perkRepository.findById(id);
    }

    public Perk createPerk(PerkRequest request) {
        Set<Category> categories = new HashSet<>(
                categoryRepository.findAllById(request.getCategoryIds()));

        Perk perk = new Perk();

        // #TO-DO: if name already exists, send warning.

        perk.setName(request.getName());
        perk.setRole(request.getRole());
        perk.setCategories(categories);

        return perkRepository.save(perk);
    }

    public Perk updatePerk(Long id, PerkRequest request){
        Perk perk = perkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perk not found."));

        if (request.getName() != null) {
            perk.setName(request.getName());
        }

        if (request.getRole() != null) {
            perk.setRole(request.getRole());
        }

        if (request.getCategoryIds() != null) {
            Set<Category> categories = new HashSet<>(
                    categoryRepository.findAllById(request.getCategoryIds()));
            perk.setCategories(categories);
        }

        return perkRepository.save(perk);
    }

    public void deletePerk(Long id) {
        perkRepository.deleteById(id);
    }
}

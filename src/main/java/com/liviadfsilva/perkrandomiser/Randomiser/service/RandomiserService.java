package com.liviadfsilva.perkrandomiser.Randomiser.service;

import com.liviadfsilva.perkrandomiser.Category.repository.CategoryRepository;
import com.liviadfsilva.perkrandomiser.Perk.repository.PerkRepository;
import com.liviadfsilva.perkrandomiser.User.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RandomiserService {

    private final PerkRepository perkRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public RandomiserService(PerkRepository perkRepository,
                             CategoryRepository categoryRepository,
                             UserRepository userRepository){
        this.perkRepository = perkRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    // #TO-DO: import random, get 4 perks (random, totem, co-op, etc)
}

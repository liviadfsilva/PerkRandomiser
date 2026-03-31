package com.liviadfsilva.perkrandomiser.Category.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.liviadfsilva.perkrandomiser.Category.model.Category;
import com.liviadfsilva.perkrandomiser.Category.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository repository;
    
    public CategoryService(CategoryRepository repository){
        this.repository = repository;
    }

    public List<Category> getAllCategories(){
        return repository.findAll();
    }
}

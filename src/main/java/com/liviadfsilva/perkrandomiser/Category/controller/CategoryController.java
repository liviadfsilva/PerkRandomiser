package com.liviadfsilva.perkrandomiser.Category.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liviadfsilva.perkrandomiser.Category.model.Category;
import com.liviadfsilva.perkrandomiser.Category.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    private CategoryController(CategoryService service){
        this.service = service;
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return service.getAllCategories();
    }
}

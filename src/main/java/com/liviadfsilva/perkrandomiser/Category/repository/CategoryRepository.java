package com.liviadfsilva.perkrandomiser.Category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.liviadfsilva.perkrandomiser.Category.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}

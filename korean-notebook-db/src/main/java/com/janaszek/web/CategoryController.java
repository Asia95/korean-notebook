package com.janaszek.web;

import com.janaszek.persistence.category.model.Category;
import com.janaszek.persistence.category.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

}

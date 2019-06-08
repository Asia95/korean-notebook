package com.janaszek.persistence.category.repo;

import com.janaszek.persistence.category.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findByCategory(String category);
}

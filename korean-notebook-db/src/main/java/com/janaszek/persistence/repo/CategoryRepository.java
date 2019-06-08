package com.janaszek.persistence.repo;

import com.janaszek.persistence.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findByCategory(String category);
}

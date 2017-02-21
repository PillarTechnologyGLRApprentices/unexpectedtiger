package com.pillartechnology.unexpectedtiger.services;

import com.pillartechnology.unexpectedtiger.model.Category;
import com.pillartechnology.unexpectedtiger.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Iterable<Category> listAllCategories() {
        return categoryRepository.findAll();
    }
}

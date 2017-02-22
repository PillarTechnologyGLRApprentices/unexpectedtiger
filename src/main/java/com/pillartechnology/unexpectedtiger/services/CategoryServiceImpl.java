package com.pillartechnology.unexpectedtiger.services;

import com.pillartechnology.unexpectedtiger.entity.CategoryEntity;
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
    public Iterable<CategoryEntity> listAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity getCategoryById(Integer id) {
        return categoryRepository.findOne(id);
    }
}

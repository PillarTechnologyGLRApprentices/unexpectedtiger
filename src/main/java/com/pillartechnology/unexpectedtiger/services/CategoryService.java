package com.pillartechnology.unexpectedtiger.services;

import com.pillartechnology.unexpectedtiger.entity.CategoryEntity;

public interface CategoryService {

    Iterable<CategoryEntity> listAllCategories();

    CategoryEntity getCategoryById(Integer id);

}

package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {
}

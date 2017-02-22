package com.pillartechnology.unexpectedtiger.loader;

import com.pillartechnology.unexpectedtiger.entity.CategoryEntity;
import com.pillartechnology.unexpectedtiger.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class CategoryLoader implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        CategoryEntity categoryEntityWork = new CategoryEntity("Work");
        categoryRepository.save(categoryEntityWork);

        CategoryEntity categoryEntityPersonal = new CategoryEntity("Personal");
        categoryRepository.save(categoryEntityPersonal);

        CategoryEntity categoryEntityOther = new CategoryEntity("Other");
        categoryRepository.save(categoryEntityOther);
    }
}

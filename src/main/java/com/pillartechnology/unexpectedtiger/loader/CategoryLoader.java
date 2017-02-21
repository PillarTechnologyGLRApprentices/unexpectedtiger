package com.pillartechnology.unexpectedtiger.loader;

import com.pillartechnology.unexpectedtiger.model.Category;
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

        Category categoryWork = new Category("Work");
        categoryRepository.save(categoryWork);

        Category categoryPersonal = new Category("Personal");
        categoryRepository.save(categoryPersonal);

        Category categoryOther = new Category("Other");
        categoryRepository.save(categoryOther);
    }
}

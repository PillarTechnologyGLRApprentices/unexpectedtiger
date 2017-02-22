package com.pillartechnology.unexpectedtiger.loader;

import com.pillartechnology.unexpectedtiger.repositories.CategoryRepository;
import com.pillartechnology.unexpectedtiger.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ItemLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ItemRepository itemRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

//        ItemEntity sampleItem = new ItemEntity();
//        sampleItem.setContent("This is a sample todo");
//        CategoryEntity categoryOne = categoryRepository.findOne(1);
//        sampleItem.setCategoryEntity(categoryOne);
//        itemRepository.save(sampleItem);
    }
            }

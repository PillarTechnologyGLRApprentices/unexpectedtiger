package com.pillartechnology.unexpectedtiger.loader;

import com.pillartechnology.unexpectedtiger.model.Category;
import com.pillartechnology.unexpectedtiger.model.Item;
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

//        Item sampleItem = new Item();
//        sampleItem.setContent("This is a sample todo");
//        Category categoryOne = categoryRepository.findOne(1);
//        sampleItem.setCategory(categoryOne);
//        itemRepository.save(sampleItem);
    }
}

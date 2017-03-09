package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.entities.ItemEntity;
import com.pillartechnology.unexpectedtiger.services.ItemDBServiceImpl;
import com.pillartechnology.unexpectedtiger.services.ItemService;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class ItemRepository {

    private ItemService itemService;

    public ItemRepository(ItemDBServiceImpl itemDBServiceImpl) {
        this.itemService = itemDBServiceImpl;
    }

    public ItemEntity add(ItemEntity item) throws IOException {
        if (item.getContent() == null) {
            throw new RuntimeException();
        }
        item = itemService.save(item);

        return item;
    }

    public Iterable<ItemEntity> retrieveAllItems() throws IOException {
        final Iterable<ItemEntity> entities = itemService.findAll();

        return entities;
    }

    public void remove(ItemEntity item) throws IOException {
        itemService.delete(item);
    }


}




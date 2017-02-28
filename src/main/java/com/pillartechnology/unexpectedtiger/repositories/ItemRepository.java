package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.entities.ItemEntity;
import com.pillartechnology.unexpectedtiger.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {

    @Autowired
    private ItemDBService itemDBService;


    public Item add(Item item) throws IOException {
        if (item.getContent() == null) {
            throw new RuntimeException();
        }
        ItemEntity itemEntity = new ItemEntity(item.getContent());
        itemEntity = itemDBService.save(itemEntity);

        item.setId(String.valueOf(itemEntity.getId()));

        return item;
    }

    public List<Item> retrieveAllItems() throws IOException {
        final Iterable<ItemEntity> entities = itemDBService.findAll();
        final List<Item> items = new ArrayList<>();
        for (ItemEntity entity : entities) {
            final Item item = new Item();
            item.setContent(entity.getContent());
            item.setId(String.valueOf(entity.getId()));
            items.add(item);
        }

        return items;
    }

    public void remove(Item item) throws IOException {
        itemDBService.delete(Integer.valueOf(item.getId()));
    }


}




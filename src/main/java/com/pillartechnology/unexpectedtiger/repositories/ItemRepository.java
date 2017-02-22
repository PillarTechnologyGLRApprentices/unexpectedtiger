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
        if (item.getContent() == null || item.getContent().trim().isEmpty()) {
            throw new RuntimeException();
        }
        ItemEntity itemEntity = convertItemToItemEntity(item);
        itemEntity = itemDBService.save(itemEntity);
        Item addedItem = convertItemEntityToItem(itemEntity);
        return addedItem;
    }


    public List<Item> retrieveAllItems() throws IOException {
        final Iterable<ItemEntity> itemEntities = itemDBService.findAll();
        List<Item> items = new ArrayList<>();
        for(ItemEntity itemEntity: itemEntities) {
            Item item = convertItemEntityToItem(itemEntity);
            items.add(item);
        }
        return items;
    }

    public void remove(Item item) throws IOException {
        itemDBService.delete(convertItemToItemEntity(item));
    }

    private ItemEntity convertItemToItemEntity(Item item) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setContent(item.getContent());
        if (item.getId() != null) {
            itemEntity.setId(Long.valueOf(item.getId()));
        }
        return itemEntity;
    }

    private Item convertItemEntityToItem(ItemEntity itemEntity) {
        Item addedItem = new Item(itemEntity.getContent());
        addedItem.setId(String.valueOf(itemEntity.getId()));
        return addedItem;
    }

}




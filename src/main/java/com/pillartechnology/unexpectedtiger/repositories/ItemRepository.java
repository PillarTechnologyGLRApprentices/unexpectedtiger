package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.ItemService;
import com.pillartechnology.unexpectedtiger.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class ItemRepository {

    @Autowired
    private ItemService itemService;


    public Item add(Item item) throws IOException {
        if (item.getContent() == null || item.getContent().trim().isEmpty()) {
            throw new RuntimeException();
        }

        return itemService.addItem(item);
    }

    public List<Item> retrieveAllItems() throws IOException {
        return itemService.retrieveItems();
    }

    public void removeLast() {
        itemService.removeLastItem();
    }

    public void remove(Item item) throws IOException {
        itemService.removeItem(item);
    }


}




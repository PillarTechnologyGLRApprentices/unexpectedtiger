package com.pillartechnology.unexpectedtiger.services;

import com.pillartechnology.unexpectedtiger.model.Item;

public interface ItemService {

    Iterable<Item> listAllItems();

    Item getItemById(Integer id);

    Item saveItem(Item item);

    void deleteItem(Integer id);
}

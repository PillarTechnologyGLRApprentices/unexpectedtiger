package com.pillartechnology.unexpectedtiger.services;

import com.pillartechnology.unexpectedtiger.entity.ItemEntity;

public interface ItemService {

    Iterable<ItemEntity> listAllItems();

    ItemEntity getItemById(Integer id);

    ItemEntity saveItem(ItemEntity itemEntity);

    void deleteItem(Integer id);
}

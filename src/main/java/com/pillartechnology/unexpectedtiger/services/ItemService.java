package com.pillartechnology.unexpectedtiger.services;

import com.pillartechnology.unexpectedtiger.entities.ItemEntity;

import java.io.IOException;
import java.util.List;

public interface ItemService {

    ItemEntity save(ItemEntity item) throws IOException;

    List<ItemEntity> findAll() throws IOException;

    void delete(ItemEntity item);
}

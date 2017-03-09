package com.pillartechnology.unexpectedtiger.services;

import com.pillartechnology.unexpectedtiger.entities.ItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemDBServiceImpl extends ItemService, CrudRepository<ItemEntity, Integer> {

    @Override
    ItemEntity save(ItemEntity item);

    @Override
    List<ItemEntity> findAll();

    @Override
    void delete(ItemEntity item);
}

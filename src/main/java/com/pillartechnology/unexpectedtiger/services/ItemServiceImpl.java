package com.pillartechnology.unexpectedtiger.services;

import com.pillartechnology.unexpectedtiger.entity.ItemEntity;
import com.pillartechnology.unexpectedtiger.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Iterable<ItemEntity> listAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public ItemEntity getItemById(Integer id) {
        return itemRepository.findOne(id);
    }

    @Override
    public ItemEntity saveItem(ItemEntity itemEntity) {
        return itemRepository.save(itemEntity);
    }

    @Override
    public void deleteItem(Integer id) {
         itemRepository.delete(id);
    }
}

package com.pillartechnology.unexpectedtiger.services;

import com.pillartechnology.unexpectedtiger.model.Item;
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
    public Iterable<Item> listAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Integer id) {
        return itemRepository.findOne(id);
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(Integer id) {
        itemRepository.delete(id);
    }
}

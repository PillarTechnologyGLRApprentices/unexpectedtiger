package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class ItemRepositoryTest {

    private ItemRepository itemRepository;

    @Test
    public void removeItems() {
        itemRepository = new ItemRepository();
        Item item = new Item("Make the bed");
        itemRepository.add(item);

        List<Item> todoItems = itemRepository.getTodoItems();

        Assert.assertEquals(todoItems.get(0),item);

        itemRepository.removeLastItem();
        Assert.assertEquals(todoItems.size(), 0);
    }

    @Test
    public void removeLastItem_will_not_remove_from_emptyList() {
        itemRepository = new ItemRepository();

        List<Item> todoItems = itemRepository.getTodoItems();

        itemRepository.removeLastItem();
        Assert.assertEquals(todoItems.size(),0);

    }

}
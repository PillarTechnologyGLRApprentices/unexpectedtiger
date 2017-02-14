package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class ItemRepositoryTest {

    private ItemRepository itemRepository;

    @Test
    public void removeItems() {
        itemRepository = new ItemRepository();
        Item item = new Item("Make the bed");
        itemRepository.add(item);

        List<Item> todoItems = itemRepository.getTodoItems();
        Assert.assertEquals(todoItems.get(0),item);

        itemRepository.remove(item);
        Assert.assertEquals(todoItems.size(), 0);
    }

}
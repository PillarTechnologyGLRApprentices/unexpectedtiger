package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ItemRepositoryTest {

    @Test
    public void retrieveAllItems_returns_empty_list() {
        //arrange
        ItemRepository itemRepository = new ItemRepository();

        //act
        List<Item> actualItems = itemRepository.retrieveAllItems();

        //assert
        Assert.assertNotNull(actualItems);
    }

    @Test
    public void retrieveAllItems_returns_a_list_with_one_item() {
        //arrange
        ItemRepository itemRepository = new ItemRepository();
        Item item = new Item("test");

        //act
        itemRepository.add(item);
        List<Item> actualItems = itemRepository.retrieveAllItems();

        //assert
        Assert.assertEquals("test", actualItems.get(0).getContent());
    }

    @Test
    public void retrieveAllItems_returns_a_list_with_two_items() {
        //arrange
        ItemRepository itemRepository = new ItemRepository();
        Item item1 = new Item("test");
        Item item2 = new Item("test2");

        //act
        itemRepository.add(item1);
        itemRepository.add(item2);
        List<Item> actualItems = itemRepository.retrieveAllItems();

        //assert
        Assert.assertEquals("test", actualItems.get(0).getContent());
        Assert.assertEquals("test2", actualItems.get(1).getContent());
    }

    @Test
    public void removeItems() {
        //arrange
        ItemRepository itemRepository = new ItemRepository();
        Item item = new Item();
        itemRepository.add(item);

        itemRepository.remove();
        final List<Item> actualItems = itemRepository.retrieveAllItems();

        Assert.assertEquals(0, itemRepository.retrieveAllItems().size());


    }


}
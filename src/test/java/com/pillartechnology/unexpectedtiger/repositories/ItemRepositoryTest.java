package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.ItemService;
import com.pillartechnology.unexpectedtiger.model.Item;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ItemRepositoryTest {

    private ItemService mockItemService;
    private ItemRepository itemRepository;

    @Before
    public void setUp() throws Exception {
        mockItemService = mock(ItemService.class);
        itemRepository = new ItemRepository(mockItemService);
    }

    @Test(expected = RuntimeException.class)
    public void add_throws_exception_when_item_content_is_null() throws Exception {
        //Arrange
        ItemService itemService = new ItemService();
        final ItemRepository itemRepository = new ItemRepository(itemService);
        final Item item = new Item();

        //Act
        itemRepository.add(item);
    }

    @Test
    public void add_invokes_addItem() throws Exception {
        //Act
        Item expectedItem = new Item("content");
        itemRepository.add(expectedItem);

        //Assert
        verify(mockItemService).addItem(expectedItem);

    }

    @Test
    public void retrieveAllItems_invokes_remove_item() throws Exception {
        //Act
        itemRepository.retrieveAllItems();

        //Assert
        verify(mockItemService).retrieveItems();
    }

    @Test
    public void remove_invokes_remove_item() throws Exception {
        //Act
        Item expectedItem = new Item("content");
        itemRepository.remove(expectedItem);

        //Assert
        verify(mockItemService).removeItem(expectedItem);
    }
}
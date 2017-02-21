package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.ItemService;
import com.pillartechnology.unexpectedtiger.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;


public class ItemRepositoryTest {

    @Mock
    private ItemService mockItemService;

    @InjectMocks
    private ItemRepository itemRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = RuntimeException.class)
    public void add_throws_exception_when_item_content_is_null() throws Exception {
        //Arrange
        final ItemRepository itemRepository = new ItemRepository();
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
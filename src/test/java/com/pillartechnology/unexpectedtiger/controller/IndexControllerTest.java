package com.pillartechnology.unexpectedtiger.controller;

import com.pillartechnology.unexpectedtiger.model.Item;
import com.pillartechnology.unexpectedtiger.services.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ExtendedModelMap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class IndexControllerTest {

    @Test
    public void saveAnItem() {
        //Arrange
        ItemService itemService = mock(ItemService.class);

        IndexController controller = new IndexController();
        controller.setItemService(itemService);
        Item item = new Item("test1");

        //Act
        String actualRedirect = controller.add(item);

        //Assert
        Mockito.verify(itemService).saveItem(item);
        assertEquals("redirect:/", actualRedirect);
    }

    @Test
    public void index_sets_list_of_all_items() throws Exception {
        //Arrange
        ItemService itemServiceMock = mock(ItemService.class);

        IndexController controller = new IndexController();
        controller.setItemService(itemServiceMock);

        List<Item> items = new ArrayList<>();
        items.add(new Item("content"));
        when(itemServiceMock.listAllItems()).thenReturn(items);

        //Act
        ExtendedModelMap model = new ExtendedModelMap();
        String actualRedirect = controller.index(model);

        Iterable<Item> actualItems = (Iterable<Item>) model.get("items");
        //Assert
        for (Item item : actualItems) {
            assertEquals("content", item.getContent());
        }
        assertEquals("index", actualRedirect);
    }

    @Test
    public void indexControllerDeletesAnItem() {
        //Arrange
        ItemService itemServiceMock = mock(ItemService.class);

        IndexController controller = new IndexController();
        controller.setItemService(itemServiceMock);

        //Act
        String actualRedirect = controller.remove(2);

        //Assert
        assertEquals("redirect:/", actualRedirect);
        verify(itemServiceMock).deleteItem(2);
    }







}
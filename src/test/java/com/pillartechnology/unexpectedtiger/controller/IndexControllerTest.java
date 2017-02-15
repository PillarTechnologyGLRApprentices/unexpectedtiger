package com.pillartechnology.unexpectedtiger.controller;

import com.pillartechnology.unexpectedtiger.model.Item;
import com.pillartechnology.unexpectedtiger.services.ItemService;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;


public class IndexControllerTest {

    @Test
    public void saveAnItem() {

        ItemService itemService = mock(ItemService.class);

        IndexController controller = new IndexController();
        controller.setItemService(itemService);
        Item item = new Item("test");
        controller.add(item);

        Mockito.verify(itemService).saveItem(item);
    }




}
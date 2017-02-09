package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;

import java.util.Arrays;
import java.util.List;

/**
 * Created by erinbergman on 2/9/17.
 */
public class ItemRepository {

    private static final List<Item> todoItems = Arrays.asList(
            new Item("Item1"),
            new Item("Item2")
    );

    public static List<Item> getTodoItems() {
        return todoItems;
    }


}

package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erinbergman on 2/9/17.
 */
public class ItemRepository {

    public static List<Item> todoItems = new ArrayList<>();


    public static List<Item> getTodoItems() {
        return todoItems;
    }


}

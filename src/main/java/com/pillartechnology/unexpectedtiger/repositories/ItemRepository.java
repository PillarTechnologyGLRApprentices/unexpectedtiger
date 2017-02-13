package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {

    private List<Item> todoItems = new ArrayList<>();


    public List<Item> getTodoItems() {
        return todoItems;
    }

    public void add(Item item) {
        todoItems.add(item);
    }

}

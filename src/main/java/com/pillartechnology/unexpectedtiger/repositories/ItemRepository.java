package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {

    private List<Item> todoItems = new ArrayList<>();

    public void add(Item item) {
        todoItems.add(item);
    }

    public List<Item> retrieveAllItems() {
        return todoItems;
    }

    public void removeLastItem() {
        if (todoItems.size() > 0) {
            todoItems.remove(todoItems.size() - 1);
        }

    }

    public void remove(Item item) {
        todoItems.remove(item);
        System.out.println("removed");
    }


}




package com.pillartechnology.unexpectedtiger.controller;

import com.pillartechnology.unexpectedtiger.model.Item;
import com.pillartechnology.unexpectedtiger.repositories.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by erinbergman on 2/8/17.
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    String index(ModelMap model) {
        List<Item> itemsFromRepo = ItemRepository.getTodoItems();
        model.put("todoItems", itemsFromRepo);
        model.addAttribute("item", new Item());
        return "index";
    }

    @RequestMapping("/add")
    String add(Item item) {
        System.out.println("We made it here");
        return "index";
    }








    //Original way of adding two things to the arraylist and passing to index.html
//    @RequestMapping("/")
//    String index(ModelMap model) {
//        List<Item> todoItems = new ArrayList<>();
//        todoItems.add("Item1");
//        todoItems.add("Item2");
//        model.put("todoItems", todoItems);
//        return "index";
//    }
}

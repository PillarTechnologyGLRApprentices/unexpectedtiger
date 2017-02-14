package com.pillartechnology.unexpectedtiger.controller;

import com.pillartechnology.unexpectedtiger.model.Item;
import com.pillartechnology.unexpectedtiger.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping("/")
    String index(ModelMap model) {

//        model.put("todoItems", itemRepository.getTodoItems());
        model.addAttribute("item", new Item());
        return "index";
    }

    @RequestMapping("/add")
    String add(Item item) {
        itemRepository.add(item);
        return "redirect:/";
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

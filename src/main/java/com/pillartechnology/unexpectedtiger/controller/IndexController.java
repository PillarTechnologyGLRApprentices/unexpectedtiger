package com.pillartechnology.unexpectedtiger.controller;

import com.pillartechnology.unexpectedtiger.model.Item;
import com.pillartechnology.unexpectedtiger.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ItemRepository itemRepository;



    @RequestMapping("/")
    String index(ModelMap model) {

        model.put("todoItems", itemRepository.getTodoItems());
        model.addAttribute("item", new Item());
        return "index";
    }

    @RequestMapping("/add")
    String add(Item item) {
        itemRepository.add(item);
        return "redirect:/";
    }

    @RequestMapping("/remove")
    String remove() {
        itemRepository.removeLastItem();
        return "redirect:/";
    }


}

package com.pillartechnology.unexpectedtiger.controller;

import com.pillartechnology.unexpectedtiger.entities.ItemEntity;
import com.pillartechnology.unexpectedtiger.model.Item;
import com.pillartechnology.unexpectedtiger.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class IndexController {

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping("/")
    String index(ModelMap model) throws IOException {
        model.put("todoItems", itemRepository.retrieveAllItems());
        model.addAttribute("item", new Item());
        return "index";
    }

    @RequestMapping("/add")
    String add(ItemEntity itemEntity) throws IOException {
        itemRepository.add(itemEntity);
        return "redirect:/";
    }


    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    String remove(@RequestParam("id") Long id) throws IOException {
        ItemEntity item = new ItemEntity();
        item.setId(id);
        itemRepository.remove(item);
        return "redirect:/";
    }
}

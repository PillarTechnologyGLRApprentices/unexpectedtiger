package com.pillartechnology.unexpectedtiger.controller;

import com.pillartechnology.unexpectedtiger.model.Item;
import com.pillartechnology.unexpectedtiger.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class IndexController {

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping("/")
    String index(ModelMap model) throws IOException {

//      model.put("todoItems", itemRepository.retrieveAllItems());
//        model.addAttribute("item", new Item());
        return "index";
    }

    @RequestMapping("/add")
    String add(Item item) throws IOException {
        itemRepository.add(item);
        return "redirect:/";
    }
//
//    @RequestMapping(value= "/add", method=RequestMethod.POST, params="action=removeLastItem")
//    String removeLastItem() {
//        itemRepository.removeLastItem();
//        return "redirect:/";
//    }
//
//    @RequestMapping(value= "/remove", method=RequestMethod.GET)
//    String remove(@RequestParam("fileName") String fileName) throws IOException {
//        Item item = new Item();
//        System.out.println(fileName);
//        item.setFileName(fileName);
//        itemRepository.remove(item);
//        return "redirect:/";
//    }









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

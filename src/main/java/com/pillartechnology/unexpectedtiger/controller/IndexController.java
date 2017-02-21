package com.pillartechnology.unexpectedtiger.controller;

import com.pillartechnology.unexpectedtiger.model.Category;
import com.pillartechnology.unexpectedtiger.model.Item;
import com.pillartechnology.unexpectedtiger.services.CategoryService;
import com.pillartechnology.unexpectedtiger.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    private ItemService itemService;
    private CategoryService categoryService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String index(Model model) {
        model.addAttribute("items", itemService.listAllItems());
        model.addAttribute("item", new Item());
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categoryService.listAllCategories());
        return "index";
    }

    @RequestMapping("/add")
    String add(Item item, Category category) {
        item.setCategory(category);
        itemService.saveItem(item);
        return "redirect:/";
    }

    @RequestMapping("/remove/{id}")
    String remove(@PathVariable Integer id) {
        itemService.deleteItem(id);
        return "redirect:/";
    }
}

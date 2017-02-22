package com.pillartechnology.unexpectedtiger.controller;

import com.pillartechnology.unexpectedtiger.entity.CategoryEntity;
import com.pillartechnology.unexpectedtiger.entity.ItemEntity;
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
        model.addAttribute("itemsEntities", itemService.listAllItems());
        model.addAttribute("itemEntity", new ItemEntity());
        model.addAttribute("categoryEntity", new CategoryEntity());
        model.addAttribute("categoryEntities", categoryService.listAllCategories());
        return "index";
    }

    @RequestMapping("/add")
    String add(ItemEntity itemEntity, CategoryEntity categoryEntity) {
        itemEntity.setCategoryEntity(categoryEntity);
        itemService.saveItem(itemEntity);
        return "redirect:/";
    }

    @RequestMapping("/remove/{id}")
    String remove(@PathVariable Integer id) {
        itemService.deleteItem(id);
        return "redirect:/";
    }
}

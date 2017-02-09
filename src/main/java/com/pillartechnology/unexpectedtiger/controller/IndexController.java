package com.pillartechnology.unexpectedtiger.controller;

import com.pillartechnology.unexpectedtiger.model.TestObj;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erinbergman on 2/8/17.
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    String index(ModelMap model) {
        List<String> todoItems = new ArrayList<>();
        todoItems.add("Item1");
        todoItems.add("Item2");
        model.put("todoItems", todoItems);
        return "index";
    }
}

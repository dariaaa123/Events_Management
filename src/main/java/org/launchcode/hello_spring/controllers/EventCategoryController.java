package org.launchcode.hello_spring.controllers;

import jakarta.validation.Valid;
import org.launchcode.hello_spring.data.EventCategoryRepository;
import org.launchcode.hello_spring.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("eventCategories")
public class EventCategoryController {
    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    //findaal, save, findById
    @GetMapping
    public String displayAllCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "eventCategories/index";

    }

    //lives at /events/create
    @GetMapping("create")
    public String displayCreateCategoryForm(Model model) {
        model.addAttribute("title", "Create Category");
        model.addAttribute(new EventCategory());
       // model.addAttribute("types",eventCategoryRepository.findAll() );
        return "eventCategories/create";
    }

    //lives at /events/create
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid EventCategory newCategory,
                                         Errors errors, Model model) {
        if(errors.hasErrors())
        {
            model.addAttribute("title", "Create Category");
            return "eventCategories/create";
        }
        eventCategoryRepository.save(newCategory);
        return "redirect:/eventCategories";
    }

}

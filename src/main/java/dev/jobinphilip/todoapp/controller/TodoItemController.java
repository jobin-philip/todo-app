package dev.jobinphilip.todoapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.jobinphilip.todoapp.repository.TodoItemRepository;

@Controller
public class TodoItemController {

    private static final Logger logger = LoggerFactory.getLogger(TodoItemController.class);

    private final TodoItemRepository todoItemRepository;

    @Autowired
    public TodoItemController(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping("/")
    public ModelAndView showIndexPage(){

        logger.debug("Entering showIndexPage method.");

        logger.info("Received GET request for /index");

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemRepository.findAll());

        logger.debug("Rendering the index page.");
        return modelAndView;
    }
    
}

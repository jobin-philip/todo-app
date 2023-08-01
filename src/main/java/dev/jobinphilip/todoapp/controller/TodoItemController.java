package dev.jobinphilip.todoapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoItemController {

    private static final Logger logger = LoggerFactory.getLogger(TodoItemController.class);

    @GetMapping("/")
    public ModelAndView showIndexPage(){

        logger.debug("Entering showIndexPage method.");

        logger.info("Received GET request for /index");

        ModelAndView modelAndView = new ModelAndView("index");

        logger.debug("Rendering the index page.");
        return modelAndView;
    }
    
}

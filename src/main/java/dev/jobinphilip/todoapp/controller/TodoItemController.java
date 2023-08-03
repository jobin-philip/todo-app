package dev.jobinphilip.todoapp.controller;

import java.time.Instant;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.jobinphilip.todoapp.model.TodoItem;
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
    public ModelAndView showIndexPage() {

        logger.debug("Entering showIndexPage method.");

        logger.info("Received GET request for /index");

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemRepository.findAll());

        logger.debug("Rendering the index page.");
        return modelAndView;
    }

    @PostMapping("/todo/{id}")
    public String editTodoItem(@PathVariable("id") long id, @Valid TodoItem todoItem, BindingResult result,
            Model model) {
        logger.debug("Entering editTodoItem method. ID: {}", id);

        if (result.hasErrors()) {
            logger.info("Validation errors found. ID: {}", id);
            todoItem.setId(id);
            return "edit-todo-item";
        }

        todoItem.setModifiedDate(Instant.now());
        todoItemRepository.save(todoItem);
        logger.info("Edited TodoItem with ID: {}", id);
        return "redirect:/";
    }

}

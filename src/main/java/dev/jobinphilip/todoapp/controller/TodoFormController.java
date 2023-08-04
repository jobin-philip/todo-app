package dev.jobinphilip.todoapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dev.jobinphilip.todoapp.model.TodoItem;
import dev.jobinphilip.todoapp.repository.TodoItemRepository;

@Controller
public class TodoFormController {

    private static final Logger logger = LoggerFactory.getLogger(TodoFormController.class);

    private final TodoItemRepository todoItemRepository;

    @Autowired
    public TodoFormController(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem){
        return "add-todo-item";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        logger.debug("Entering showEditForm method. ID: {}", id);

        TodoItem todoItem = todoItemRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        logger.info("Found TodoItem with ID: {}", id);

        model.addAttribute("todoItem", todoItem);
        return "edit-todo-item";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") long id, Model model) {
        logger.debug("Entering deleteTodoItem method. ID: {}", id);

        TodoItem todoItem = todoItemRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        logger.info("Deleting TodoItem with ID: {}", id);

        todoItemRepository.delete(todoItem);
        return "redirect:/";
    }
}

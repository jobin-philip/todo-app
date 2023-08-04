package dev.jobinphilip.todoapp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.jobinphilip.todoapp.model.TodoItem;
import dev.jobinphilip.todoapp.repository.TodoItemRepository;

@Component
public class TodoItemDataLoader implements CommandLineRunner{
    
    private static final Logger logger = LoggerFactory.getLogger(TodoItemDataLoader.class);

    private final TodoItemRepository todoItemRepository;

    //@Autowired
    public TodoItemDataLoader(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        if (todoItemRepository.count() == 0) {
            logger.info("Loading seed data for TodoItems.");

            TodoItem todoItem1 = new TodoItem("Try a new recipe");
            TodoItem todoItem2 = new TodoItem("Rake the leaves");

            todoItemRepository.save(todoItem1);
            todoItemRepository.save(todoItem2);

            logger.info("Seed data for TodoItems added successfully.");
        } else {
            logger.info("TodoItems already exist. Skipping seed data.");
        }

        logger.info("Number of TodoItems: {}", todoItemRepository.count());
    }

}

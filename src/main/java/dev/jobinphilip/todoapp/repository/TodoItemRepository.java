package dev.jobinphilip.todoapp.repository;

import org.springframework.data.repository.CrudRepository;

import dev.jobinphilip.todoapp.model.TodoItem;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long>{   
    
}

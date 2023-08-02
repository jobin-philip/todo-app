package dev.jobinphilip.todoapp.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TodoItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private boolean completed;

    private Instant createdDate;

    private Instant modifiedDate;

    public TodoItem(String description){
        this.description = description;
        this.completed = false;
        this.createdDate = Instant.now();
        this.modifiedDate = Instant.now();
    }

    @Override
    public String toString(){
        return String.format("TodoItem{id=%d, description='%s', completed='%s', createdDate='%s', modifiedDate='%s'}",
        id, description, completed, createdDate, modifiedDate);
    }
}

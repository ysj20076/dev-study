package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Todo {
    @Id @GeneratedValue
    private long id;
    private String content;
    private boolean completed;
}

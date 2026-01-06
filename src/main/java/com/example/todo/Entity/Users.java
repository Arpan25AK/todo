package com.example.todo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @com.fasterxml.jackson.annotation.JsonManagedReference //added this to stop the recursion call issue.
    private List<Todo> todos;

}

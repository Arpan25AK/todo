package com.example.todo.repository;

import com.example.todo.Entity.Todo; // Importing your Entity class
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends  JpaRepository<Todo, Long> {

}

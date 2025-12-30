package com.example.todo.Service;

import com.example.todo.Entity.Todo;
import com.example.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Todo saveAllTodos(Todo todo){
        return todoRepository.save(todo);
    }

    public Optional<Todo> getById(long id){
        return todoRepository.findById(id);
    }

    public void deleteById(long id){
         todoRepository.deleteById(id);
    }
}

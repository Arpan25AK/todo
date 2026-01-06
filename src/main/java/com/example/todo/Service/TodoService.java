package com.example.todo.Service;

import com.example.todo.Entity.Todo;
import com.example.todo.Entity.Users;
import com.example.todo.repository.TodoRepository;
import com.example.todo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    @Autowired
    private UserRepo userRepo;

    private final TodoRepository todoRepository;

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Todo saveAllTodos(Todo todo,Long userId){
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id:" + userId));
        todo.setUsers(user);
        return todoRepository.save(todo);
    }

    public Optional<Todo> getById(long id){
        return todoRepository.findById(id);
    }

    public void deleteById(long id){
         todoRepository.deleteById(id);
    }
}

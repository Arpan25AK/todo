package com.example.todo.Controller;

import com.example.todo.Entity.Todo;
import com.example.todo.Service.TodoService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class todoController {

    private final TodoService todoService;

    @GetMapping("/getAll")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @PostMapping("/create")
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.saveAllTodos(todo);
    }

    @PutMapping("/update/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        // here checking happens whether the id exists or not.
        Todo existingTodo = todoService.getById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found")); //if the id dosent match it throws the error stopping the program,

        // if the file does exist then here the update process starts
        existingTodo.setTitle(todo.getTitle());
        existingTodo.setContent(todo.getContent());
        existingTodo.setCompleted(todo.isCompleted());

        // this line saves the updated info in db.
        return todoService.saveAllTodos(existingTodo);
    }

    // this is the delete by id api which del the id if the id is found else throws error.
    @DeleteMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        if (!todoService.getById(id).isPresent()) {
            throw new RuntimeException("Todo not found with ID: " + id);
        }
        todoService.deleteById(id);
        return "Todo with ID " + id + " has been deleted.";
    }
    // next going to integrate the crud with authorization so each users have the ability to create their own todolist.
}

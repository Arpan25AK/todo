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
    public List<Todo> getAllTodos(){// this api calls is only used to get all the todo or entries from the db.
        return todoService.getAllTodos();
    }

    @PostMapping("/create/{userId}")
    public Todo createTodo(@RequestBody Todo todo,@PathVariable Long userId){ // now added the userId to the path variable so the link is established with the tododb
        return todoService.saveAllTodos(todo,userId);
    }

    @PutMapping("/update/{id}")// this api is called to update the existing todo by checking if the todo id matches and if so changhes are applied.
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        // here checking happens whether the id exists or not.
        Todo existingTodo = todoService.getById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found")); //if the id dosen't match it throws the error stopping the program,

        // if the file does exist then here the update process starts
        existingTodo.setTitle(todo.getTitle());
        existingTodo.setContent(todo.getContent());
        existingTodo.setCompleted(todo.isCompleted());

        // this line saves the updated info in db.
        return todoService.updateTodo(existingTodo);
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

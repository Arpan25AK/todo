package com.example.todo.Controller;

import com.example.todo.Entity.Users;
import com.example.todo.Service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@NoArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("/create")
    public Users createUser(@RequestBody Users users){
        return userService.saveUser(users);
    }

}

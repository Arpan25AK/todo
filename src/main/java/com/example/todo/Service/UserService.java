package com.example.todo.Service;

import com.example.todo.Entity.Users;
import com.example.todo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    public UserRepo userRepo;

    public saveUser(Users users){
        return userRepo.save(users);


    }
}

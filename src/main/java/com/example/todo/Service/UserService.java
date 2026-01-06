package com.example.todo.Service;

import com.example.todo.Entity.Users;
import com.example.todo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserRepo userRepo;

    public List<Users> findAllUsers(){
        return userRepo.findAll();
    }

    public Users findById(Long id){
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("user with id " + id + " not found"));
    }

    public Users saveUser(Users users){
        return userRepo.save(users);


    }
}

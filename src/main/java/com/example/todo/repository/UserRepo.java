package com.example.todo.repository;

import com.example.todo.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Long>{
}

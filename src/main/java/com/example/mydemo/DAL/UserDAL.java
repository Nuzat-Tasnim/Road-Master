package com.example.mydemo.DAL;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAL extends JpaRepository<User, Integer> {

    public User findByEmail(String email);
}

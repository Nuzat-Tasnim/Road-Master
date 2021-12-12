package com.example.mydemo.DAL;

import org.springframework.data.jpa.repository.JpaRepository;

public interface transportDAL extends JpaRepository<Transport, Integer> {
    public Transport findTransportById(int id);
}

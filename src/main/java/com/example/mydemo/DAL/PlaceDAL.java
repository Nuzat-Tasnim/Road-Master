package com.example.mydemo.DAL;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceDAL extends JpaRepository<Place, Integer> {

    public Place findPlaceByPlaceId(int id);
    public List<Place> findAllByPlaceNameContainingIgnoreCase(String name);
}

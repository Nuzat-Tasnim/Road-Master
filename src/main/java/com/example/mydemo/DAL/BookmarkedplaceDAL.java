package com.example.mydemo.DAL;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkedplaceDAL extends JpaRepository<BookmarkedPlaces,Integer> {
    public BookmarkedPlaces findBookmarkedPlacesByUser(User user);
}

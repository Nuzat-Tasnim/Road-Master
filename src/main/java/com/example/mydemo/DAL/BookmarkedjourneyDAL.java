package com.example.mydemo.DAL;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkedjourneyDAL extends JpaRepository<BookmarkedJourneys, Integer> {
    public BookmarkedJourneys findBookmarkedJourneysByUser(User user);
}

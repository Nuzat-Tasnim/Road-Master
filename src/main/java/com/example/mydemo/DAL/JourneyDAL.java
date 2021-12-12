package com.example.mydemo.DAL;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JourneyDAL extends JpaRepository <Journey, Integer>{

    Journey findJourneyByJourneyId(int id);

    List<Journey> getAllBySource_PlaceNameAndDestination_PlaceNameIgnoreCase(String source, String destination);


}

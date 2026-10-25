package com.crewManagement.crew.service;


import com.crewManagement.crew.entity.CrewEntity;
import com.crewManagement.crew.Repo.CrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrewService {

    @Autowired
    private CrewRepository crewRepository;


    // CREATE
    public CrewEntity addCrew(CrewEntity crew) {
        return crewRepository.save(crew);
    }


    // READ ALL
    public List<CrewEntity> getAllCrew() {
        return crewRepository.findAll();
    }


    // READ BY ID
    public CrewEntity getCrewById(Long id) {
        return crewRepository.findById(id).orElse(null);
    }


    // UPDATE
    public CrewEntity updateCrew(Long id, CrewEntity crew) {

        CrewEntity existingCrew = crewRepository.findById(id).orElse(null);

        if (existingCrew != null) {

            existingCrew.setCrewName(crew.getCrewName());
            existingCrew.setDob(crew.getDob());
            existingCrew.setPassportNumber(crew.getPassportNumber());
            existingCrew.setPassportExpiryDate(crew.getPassportExpiryDate());
            existingCrew.setFlightNumberAssigned(crew.getFlightNumberAssigned());
            existingCrew.setOriginAirport(crew.getOriginAirport());
            existingCrew.setDestinationAirport(crew.getDestinationAirport());
            existingCrew.setJourneyStatus(crew.getJourneyStatus());

            return crewRepository.save(existingCrew);
        }

        return null;
    }


    // DELETE
    public String deleteCrew(Long id) {

        crewRepository.deleteById(id);

        return "Crew deleted successfully";
    }
}
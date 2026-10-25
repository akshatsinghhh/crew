package com.crewManagement.crew.controller;



import com.crewManagement.crew.entity.CrewEntity;
import com.crewManagement.crew.service.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/crew")
public class CrewController {

    @Autowired
    private CrewService crewService;


    // CREATE
    @PostMapping("/addcrew")
    public CrewEntity addCrew(@RequestBody CrewEntity crew) {
        return crewService.addCrew(crew);
    }


    // READ ALL
    @GetMapping("/getallcrews")
    public List<CrewEntity> getAllCrew() {
        return crewService.getAllCrew();
    }


    // READ BY ID
    @GetMapping("getbyid/{id}")
    public CrewEntity getCrewById(@PathVariable Long id) {
        return crewService.getCrewById(id);
    }


    // UPDATE
    @PutMapping("/{id}/status")
    public CrewEntity updateCrew(@PathVariable Long id,
                           @RequestBody CrewEntity crew) {

        return crewService.updateCrew(id, crew);
    }


    // DELETE
    @DeleteMapping("/{id}")
    public String deleteCrew(@PathVariable Long id) {
        return crewService.deleteCrew(id);
    }
}
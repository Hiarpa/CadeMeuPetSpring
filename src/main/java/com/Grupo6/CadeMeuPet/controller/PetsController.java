package com.Grupo6.CadeMeuPet.controller;

import com.Grupo6.CadeMeuPet.models.Pets;
import com.Grupo6.CadeMeuPet.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/pet")
public class PetsController {

    private final PetsService petsService;

    @Autowired
    public PetsController(PetsService petsService) {
        this.petsService = petsService;
    }

    @GetMapping
    public List<Pets> getPets(){
        return petsService.getPets();
    }

    @GetMapping("/{petId}")
    public Optional<Pets> getPetsById(@PathVariable Integer petId){
        return petsService.getPetById(petId);
    }

    @PostMapping
    public void registerNewPet(@RequestBody Pets pet){
        petsService.addNewPet(pet);
    }

    @DeleteMapping(path = "{petId}")
    public void deletePet(@PathVariable("petId") Integer petId){
        petsService.deletePet(petId);
    }

    @PatchMapping(path = "{petId}")
    public void updatePet(@PathVariable("petId") Integer petId, @RequestBody Pets petDetails){
      petsService.updatePet(petId,petDetails);
    }
}

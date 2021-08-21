package com.Grupo6.CadeMeuPet.controller;

import com.Grupo6.CadeMeuPet.models.Occurrences;
import com.Grupo6.CadeMeuPet.service.OccurrencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/occurrences")
public class OccurrencesController {

    private final OccurrencesService occurrencesService;

    @Autowired
    private OccurrencesController(OccurrencesService occurrencesService) {
        this.occurrencesService = occurrencesService;
    }

    @GetMapping
    public List<Occurrences> getOccurrences(){
        return occurrencesService.getOccurrences();
    }

    @GetMapping("/{occurrencesId}")
    public Optional<Occurrences> getOccurrencesById(@PathVariable Integer occurrencesId) {
        return occurrencesService.getOccurrencesById(occurrencesId);
    }

    @PostMapping
    public void registerNewOccurrences(@RequestBody Occurrences occurrences, @RequestParam Integer userId, @RequestParam Integer petId){

        occurrencesService.addNewOccurrences(occurrences, userId, petId);
    }

    @DeleteMapping(path = "{occurrencesId}")
    public void deleteOccurrences(@PathVariable("occurrencesId") Integer occurrencesId){
        occurrencesService.deleteOccurrences(occurrencesId);
    }

    @PatchMapping(path = "{occurrencesId}")
    public void updateOccurrences(@PathVariable("occurrencesId") Integer occurrencesId, @RequestBody Occurrences occurrencesDetails){
        occurrencesService.updateOccurrences(occurrencesId, occurrencesDetails);
    }

}

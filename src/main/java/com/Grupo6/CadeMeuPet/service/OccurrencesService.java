package com.Grupo6.CadeMeuPet.service;


import com.Grupo6.CadeMeuPet.models.Occurrences;
import com.Grupo6.CadeMeuPet.models.Pets;
import com.Grupo6.CadeMeuPet.models.UserApp;
import com.Grupo6.CadeMeuPet.repository.OccurrencesRepository;
import com.Grupo6.CadeMeuPet.repository.PetsRepository;
import com.Grupo6.CadeMeuPet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import java.util.Objects;
import java.util.Optional;

@Service
public class OccurrencesService {
    private final UserRepository userRepository;
    private final OccurrencesRepository occurrencesRepository;
    private final PetsRepository petsRepository;

    @Autowired
    public OccurrencesService(UserRepository userRepository, OccurrencesRepository occurrencesRepository, PetsRepository petsRepository) {
        this.userRepository = userRepository;
        this.occurrencesRepository = occurrencesRepository;
        this.petsRepository = petsRepository;
    }

    public List<Occurrences> getOccurrences(){
        return occurrencesRepository.findAll();
    }

    public Optional<Occurrences> getOccurrencesById(Integer occurrencesId){
        return occurrencesRepository.findById(occurrencesId);
    }

    public void addNewOccurrences(Occurrences occurrences, Integer lostByUserID, Integer petId) {
        UserApp lostByUser = userRepository.getById(lostByUserID);
        Pets pet = petsRepository.getById(petId);

        occurrences.setUser_lost_by(lostByUser);
        occurrences.setPet(pet);
        occurrencesRepository.save(occurrences);
    }

    public void deleteOccurrences(Integer occurrencesId) {
        boolean exists = occurrencesRepository.existsById(occurrencesId);
        if (!exists) {
            throw new IllegalStateException("Occurrence With ID " + occurrencesId + " does not exist");
        }
        occurrencesRepository.deleteById(occurrencesId);
    }

    public List<Occurrences> checkPetOccurrences(Pets pet){

        List<Occurrences> occurrences = getOccurrences();
        List<Occurrences> possibles = new ArrayList<>();

        for (Occurrences index : occurrences){
            if(index.getPet().getName().equals(pet.getName()) || index.getPet().getRegister().equals(pet.getRegister())) {
                possibles.add(index);
            } else if(index.getPet().getTypePet().equals(pet.getTypePet()) && index.getPet().getCoat().equals(pet.getCoat()) && index.getPet().getColor().equals(pet.getColor()) && index.getPet().getSize().equals(pet.getSize())){
                if(index.getPet().getGender().equals(pet.getGender()) || index.getPet().getBreed().equals(pet.getBreed()) || index.getPet().getSpecies().equals(pet.getSpecies())){
                    possibles.add(index);
                }
            }
        }

        return possibles;
    }

    @Transactional
    public void updateOccurrences(Integer occurrencesId, Occurrences occurrencesDetails){
        Occurrences occurrences = occurrencesRepository.findOccurrencesById(occurrencesId);

        if (occurrencesDetails.getFound_place() != null && occurrencesDetails.getFound_place().length() > 0 && !Objects.equals(occurrences.getFound_place(), occurrencesDetails.getFound_place())){
            occurrences.setFound_place(occurrencesDetails.getFound_place());
        }
        if (occurrencesDetails.getLost_place() != null && occurrencesDetails.getLost_place().length() > 0 && !Objects.equals(occurrences.getLost_place(), occurrencesDetails.getLost_place())){
            occurrences.setFound_place(occurrencesDetails.getLost_place());
        }
        if(occurrencesDetails.getDate_lost() != null ){
            occurrences.setDate_lost(occurrencesDetails.getDate_lost());
        }
        if(occurrencesDetails.getDate_found() != null ){
            occurrences.setDate_found(occurrencesDetails.getDate_found());
        }
    }

}


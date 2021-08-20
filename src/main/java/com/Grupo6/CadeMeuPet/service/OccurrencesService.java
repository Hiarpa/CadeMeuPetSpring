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

//    public void attemptUpdateOccurrence(Occurrences occurrenceToBeUpdated, Integer userId){
//        System.out.println("Qual é o seu pet ?");
//        List<Occurrences> occurencesList = new ArrayList(occurrencesRepository.findOccurrenceByUserId(userId));
//        for (Occurrences indice: occurencesList){
//            System.out.println(petsRepository.findPetById(indice.getId()).getName() + " - " +  petsRepository.findPetById(indice.getId()).getBreed());
//        }
//    }
}


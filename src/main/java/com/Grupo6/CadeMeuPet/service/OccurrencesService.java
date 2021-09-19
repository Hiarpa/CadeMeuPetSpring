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

    public void addNewOccurrenceLost(Occurrences occurrences, Integer lostByUserId, Integer petId) {
        UserApp lostByUser = userRepository.getById(lostByUserId);
        Pets pet = petsRepository.getById(petId);

        occurrences.setLostByUser(lostByUser);
        occurrences.setPet(pet);
        occurrencesRepository.save(occurrences);
    }

    public void addNewOccurrenceFound(Occurrences occurrences, Integer foundByUserId, Integer petId) {
        UserApp foundByUser = userRepository.getById(foundByUserId);
        Pets pet = petsRepository.getById(petId);

        occurrences.setFoundByUser(foundByUser);
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

    public boolean haveSameCharacteristic(Pets occurrencePet, Pets pet){
         boolean sameApperence = occurrencePet.getTypePet().equals(pet.getTypePet()) && occurrencePet.getFur().equals(pet.getFur())
                && occurrencePet.getColor().equals(pet.getColor()) && occurrencePet.getSize().equals(pet.getSize());
         boolean sameAttribute = occurrencePet.getGender().equals(pet.getGender()) || occurrencePet.getBreed().equals(pet.getBreed()) || occurrencePet.getSpecies().equals(pet.getSpecies());
        return sameApperence && sameAttribute;
    }

    public List<Occurrences> checkPetOccurrences(Pets pet){

        List<Occurrences> occurrences = getOccurrences();
        List<Occurrences> possibles = new ArrayList<>();

        for (Occurrences index : occurrences){
            Pets occurrencePets = index.getPet();
            if(occurrencePets.getName().equals(pet.getName()) || occurrencePets.getRegister().equals(pet.getRegister())) {
                possibles.add(index);
            } else if(haveSameCharacteristic(occurrencePets, pet)){
                if(haveSameCharacteristic(occurrencePets, pet)){
                    possibles.add(index);
                }
            }
        }
        return possibles;
    }

    @Transactional
    public void updateOccurrences(Integer occurrencesId, Occurrences occurrencesDetails){
        Occurrences occurrences = occurrencesRepository.findOccurrencesById(occurrencesId);

        if (occurrencesDetails.getFoundPlace() != null && occurrencesDetails.getFoundPlace().length() > 0 && !Objects.equals(occurrences.getFoundPlace(), occurrencesDetails.getFoundPlace())){
            occurrences.setFoundPlace(occurrencesDetails.getFoundPlace());
        }
        if (occurrencesDetails.getLostPlace() != null && occurrencesDetails.getLostPlace().length() > 0 && !Objects.equals(occurrences.getLostPlace(), occurrencesDetails.getLostPlace())){
            occurrences.setFoundPlace(occurrencesDetails.getLostPlace());
        }
        if(occurrencesDetails.getDateLost() != null ){
            occurrences.setDateLost(occurrencesDetails.getDateLost());
        }
        if(occurrencesDetails.getDateFound() != null ){
            occurrences.setDateFound(occurrencesDetails.getDateFound());
        }
    }

}


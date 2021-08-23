package com.Grupo6.CadeMeuPet.service;

import com.Grupo6.CadeMeuPet.models.Pets;
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
public class PetsService {
    private final PetsRepository petsRepository;
    private final UserRepository userRepository;
    private final OccurrencesRepository occurrencesRepository;

    @Autowired
    public PetsService(PetsRepository petsRepository, UserRepository userRepository, OccurrencesRepository occurrencesRepository){
        this.petsRepository = petsRepository;
        this.userRepository = userRepository;
        this.occurrencesRepository = occurrencesRepository;
    }

    public List<Pets> getPets(){
        return petsRepository.findAll();
    }

    public List<Pets> getLostPets(){
        return occurrencesRepository.findLostOccurrences().getPet();
    }

    public List<Pets> getFoundPets(){
        return occurrencesRepository.findFoundOccurrences().getPet();
    }

    public Optional<Pets> getPetById(Integer petsId){
        return petsRepository.findById(petsId);
    }

    public void addNewPet(Pets pet,Integer userId){
        pet.setUser(userRepository.getById(userId));
        petsRepository.save(pet);
    }

    public void deletePet(Integer petId){
        boolean exists = petsRepository.existsById(petId);
        if(!exists){
            throw new IllegalStateException("pet with id" + petId + "does not exists." );
        }
        petsRepository.deleteById(petId);
    }

    @Transactional
    public void updatePet(Integer petId, Pets petDetails){
        Pets pet = petsRepository.findPetById(petId);

        if (petDetails.getName() != null && petDetails.getName().length() > 0 && !Objects.equals(pet.getName(), petDetails.getName())){
            pet.setName(petDetails.getName());
        }

        if (petDetails.getTypePet() != null && petDetails.getTypePet().length() > 0 && !Objects.equals(pet.getTypePet(),petDetails.getTypePet())){
            pet.setTypePet(petDetails.getTypePet());
        }

        if (petDetails.getGender() != null && petDetails.getGender().length() > 0 && !Objects.equals(pet.getGender(),petDetails.getGender())){
            pet.setGender(pet.getGender());
        }

    }
}

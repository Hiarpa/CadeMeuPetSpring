package com.Grupo6.CadeMeuPet.service;

import com.Grupo6.CadeMeuPet.models.Pets;
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

    @Autowired
    public PetsService(PetsRepository petsRepository, UserRepository userRepository){
        this.petsRepository = petsRepository;
        this.userRepository = userRepository;
    }

    public List<Pets> getPets(){
        return petsRepository.findAll();
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

        if (petDetails.getTipo_pet() != null && petDetails.getTipo_pet().length() > 0 && !Objects.equals(pet.getTipo_pet(),petDetails.getTipo_pet())){
            pet.setTipo_pet(petDetails.getTipo_pet());
        }

        if (petDetails.getGender() != null && petDetails.getGender().length() > 0 && !Objects.equals(pet.getGender(),petDetails.getGender())){
            pet.setGender(pet.getGender());
        }

    }
}

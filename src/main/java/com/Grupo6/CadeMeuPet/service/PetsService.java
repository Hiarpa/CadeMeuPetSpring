package com.Grupo6.CadeMeuPet.service;

import com.Grupo6.CadeMeuPet.models.Pets;
import com.Grupo6.CadeMeuPet.models.UserApp;
import com.Grupo6.CadeMeuPet.repository.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PetsService {
    private final PetsRepository petsRepository;

    @Autowired
    public PetsService(PetsRepository petsRepository){
        this.petsRepository = petsRepository;
    }

    public List<Pets> getPets(){
        return petsRepository.findAll();
    }

    public Optional<Pets> getPetById(Integer petsId){
        return petsRepository.findById(petsId);
    }

    //Colocar idUser
    public void addNewPet(Pets pet){
        Optional<Pets> petsOptional = petsRepository.findPetById(pet.getIdPets());
        if(petsOptional.isPresent()){
            throw new IllegalStateException("id already in use!!");
        }
        petsRepository.save(pet);
//      pet.setUser(userRepository.getUserById(userId);
    }

    public void deletePet(Integer petId){
        boolean exists = petsRepository.existsById(petId);
        if(!exists){
            throw new IllegalStateException("pet with id" + petId + "does not exists." );
        }
        petsRepository.deleteById(petId);
    }

}

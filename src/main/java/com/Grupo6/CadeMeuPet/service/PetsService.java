package com.Grupo6.CadeMeuPet.service;

import com.Grupo6.CadeMeuPet.models.Pets;
import com.Grupo6.CadeMeuPet.repository.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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
        Pets pets = petsRepository.findPetById(pet.getIdPets());
//        if(pets.isPresent()){
//            throw new IllegalStateException("id already in use!!");
//        }
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

    @Transactional
    public void updatePet(Integer petId, Pets petDetails){
        Pets pet = petsRepository.findPetById(petId);

        if (petDetails.getNome() != null && petDetails.getNome().length() > 0 && !Objects.equals(pet.getNome(), petDetails.getNome())){
            pet.setNome(petDetails.getNome());
        }

        if (petDetails.getTipo_pet() != null && petDetails.getTipo_pet().length() > 0 && !Objects.equals(pet.getTipo_pet(),petDetails.getTipo_pet())){
            pet.setTipo_pet(petDetails.getTipo_pet());
        }

        if (petDetails.getGenero() != null && petDetails.getGenero().length() > 0 && !Objects.equals(pet.getGenero(),petDetails.getGenero())){
            pet.setGenero(pet.getGenero());
        }

    }
}

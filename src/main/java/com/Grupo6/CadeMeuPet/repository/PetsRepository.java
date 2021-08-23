package com.Grupo6.CadeMeuPet.repository;

import com.Grupo6.CadeMeuPet.models.Pets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetsRepository extends JpaRepository<Pets, Integer> {

    @Query("SELECT s FROM Pets s WHERE s.id= ?1")
    Pets findPetById(Integer petId);

    @Query("SELECT s FROM Pets s WHERE s.typePet= ?1")
    List<Pets> findPetByType(Integer petType);

    @Query("SELECT s FROM Pets s WHERE s.size= ?1")
    List<Pets> findPetBySize(Integer petsize);

}

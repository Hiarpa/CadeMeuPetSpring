package com.Grupo6.CadeMeuPet.repository;

import com.Grupo6.CadeMeuPet.models.Pets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PetsRepository extends JpaRepository<Pets, Integer> {

    @Query("SELECT s FROM Pets s WHERE s.id= ?1")
    Pets findPetById(Integer petId);
}

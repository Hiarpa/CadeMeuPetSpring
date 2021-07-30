package com.Grupo6.CadeMeuPet.repository;

import com.Grupo6.CadeMeuPet.models.Pets;
import com.Grupo6.CadeMeuPet.models.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetsRepository extends JpaRepository<Pets, Integer> {

    @Query("SELECT s FROM Pets s WHERE s.id = ?1")
    Optional<Pets> findPetById(Integer petId);
}

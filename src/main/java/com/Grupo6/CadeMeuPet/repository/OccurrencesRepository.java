package com.Grupo6.CadeMeuPet.repository;


import com.Grupo6.CadeMeuPet.models.Occurrences;
import com.Grupo6.CadeMeuPet.models.Pets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public  interface OccurrencesRepository extends JpaRepository<Occurrences, Integer> {

    @Query("SELECT s FROM Occurrences s WHERE s.id= ?1")
    Occurrences findOccurrencesById(Integer occurrencesId);
}

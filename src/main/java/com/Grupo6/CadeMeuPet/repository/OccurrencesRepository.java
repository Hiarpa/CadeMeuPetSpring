package com.Grupo6.CadeMeuPet.repository;


import com.Grupo6.CadeMeuPet.models.Occurrences;
import com.Grupo6.CadeMeuPet.models.Pets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public  interface OccurrencesRepository extends JpaRepository<Occurrences, Integer> {

//    @Query("SELECT s FROM Occurrences s WHERE s.fk_id_lost_by OR s.fk_id_found_by")
//    List<Occurrences> findOccurrenceByUserId(Integer userId);

    @Query("SELECT s FROM Occurrences s WHERE s.id= ?1")
    Occurrences findOccurrencesById(Integer occurrencesId);

    @Query("SELECT s FROM Occurrences s WHERE s.fk_id_lost_by_user IS NOT NULL")
    Occurrences findLostOccurrences();

    @Query("SELECT s FROM Occurrences s WHERE s.fk_id_found_by_user IS NOT NULL")
    Occurrences findFoundOccurrences();


}

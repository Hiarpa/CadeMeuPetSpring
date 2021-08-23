package com.Grupo6.CadeMeuPet.repository;

import com.Grupo6.CadeMeuPet.models.Pets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface PetsRepository extends JpaRepository<Pets, Integer> {

    @Query("SELECT s FROM Pets s WHERE s.id= ?1")
    Pets findPetById(Integer petId);

    @Query("SELECT s FROM Pets s WHERE s.typePet = :type ")
    List<Pets> findPetByType(@Param("type") String type);
//
//    @Query("SELECT s FROM Pets s WHERE s.size = :size")
//    List<Pets> findPetsBySize(@Param("size") String size);
//
//    @Query("SELECT s FROM Pets s WHERE s.gender = :gender")
//    List<Pets> findPetsByGender(@Param("gender") String gender);
//
//    @Query("SELECT s FROM Pets s WHERE s.fur = :fur")
//    List<Pets> findPetsByFur(@Param("fur") String fur);

    @Query("SELECT s FROM Pets s WHERE s.status = 'Perdido'")
    List<Pets> findLostPets();

    @Query("SELECT s FROM Pets s WHERE s.status = 'Achado'")
    List<Pets> findFoundPets();

}

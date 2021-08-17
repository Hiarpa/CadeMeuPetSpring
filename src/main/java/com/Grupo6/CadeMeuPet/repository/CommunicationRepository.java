package com.Grupo6.CadeMeuPet.repository;

import com.Grupo6.CadeMeuPet.models.Communication;
import com.Grupo6.CadeMeuPet.models.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CommunicationRepository extends JpaRepository<Communication, Integer > {

    @Query("SELECT s FROM Communication s WHERE s.message = ?1")
    Optional<Communication> findUserByMessage(String message);

}

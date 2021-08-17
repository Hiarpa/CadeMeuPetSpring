package com.Grupo6.CadeMeuPet.repository;


import com.Grupo6.CadeMeuPet.models.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserApp, Integer> {

    @Query("SELECT s FROM UserApp s WHERE s.email = ?1")
    UserApp findUserByEmail(String email);

}

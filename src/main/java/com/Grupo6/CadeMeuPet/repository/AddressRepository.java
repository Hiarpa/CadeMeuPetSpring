package com.Grupo6.CadeMeuPet.repository;

import com.Grupo6.CadeMeuPet.models.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("SELECT s FROM Address s WHERE s.idAddress = ?1")
    Address findAddressById(Integer id);

}

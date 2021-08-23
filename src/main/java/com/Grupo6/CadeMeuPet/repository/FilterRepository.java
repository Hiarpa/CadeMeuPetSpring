package com.Grupo6.CadeMeuPet.repository;

import com.Grupo6.CadeMeuPet.models.Pets;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FilterRepository {

    private final PetsRepository petsRepository;


    public FilterRepository(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    public List<Pets> findWithFilter(String type, String status){
        List<Pets> result = new ArrayList<Pets>(petsRepository.findAll());
        List<Pets> petsWithFilter = new ArrayList<>();
         for(Pets indice : result){
           if(type != "todos"){
               if(indice.getTypePet().equals(type)){
                   petsWithFilter.add(indice);
               }
           }else if(status != "todos"){
               if(indice.getStatus().equals(status)){
                   petsWithFilter.add(indice);
               }
             }
         }
         if(petsWithFilter.isEmpty()){
             return result;
         }else{
             return petsWithFilter;
         }
    }
}

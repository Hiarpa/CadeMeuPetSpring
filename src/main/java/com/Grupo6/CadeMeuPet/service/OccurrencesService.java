package com.Grupo6.CadeMeuPet.service;


import com.Grupo6.CadeMeuPet.models.Occurrences;
import com.Grupo6.CadeMeuPet.models.UserApp;
import com.Grupo6.CadeMeuPet.repository.OccurrencesRepository;
import com.Grupo6.CadeMeuPet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import java.util.Optional;

@Service
public class OccurrencesService {
    private final UserRepository userRepository;
    private final OccurrencesRepository occurrencesRepository;

    @Autowired
    public OccurrencesService(UserRepository userRepository, OccurrencesRepository occurrencesRepository) {
        this.userRepository = userRepository;
        this.occurrencesRepository = occurrencesRepository;
    }


    public List<Occurrences> getOccurrences(){
        return occurrencesRepository.findAll();
    }

    public Optional<Occurrences> getOccurrencesById(Integer occurrencesId){
        return occurrencesRepository.findById(occurrencesId);
    }

    @Transactional

    public void updateOccurrences(Integer occurrencesId, Occurrences occurrencesDetails){
        Occurrences occurrences = occurrencesRepository.findOccurrencesById(occurrencesId);


    }

    public void addNewOccurrences(Occurrences occurrences, Integer lostByUserID) {
        UserApp lostByUser = userRepository.getById(lostByUserID);
        occurrences.setUser_lost_by(lostByUser);
        occurrencesRepository.save(occurrences);


    }

    public void deleteOccurrences(Integer occurrencesId) {
        boolean exists = occurrencesRepository.existsById(occurrencesId);
        if (!exists) {
            throw new IllegalStateException("Occurrence With ID " + occurrencesId + " does not exist");
        }
        occurrencesRepository.deleteById(occurrencesId);

    }
}


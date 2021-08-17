package com.Grupo6.CadeMeuPet.service;

import com.Grupo6.CadeMeuPet.models.Communication;
import com.Grupo6.CadeMeuPet.models.Pets;
import com.Grupo6.CadeMeuPet.models.UserApp;
import com.Grupo6.CadeMeuPet.repository.CommunicationRepository;
import com.Grupo6.CadeMeuPet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CommunicationService {
    private CommunicationRepository communicationRepository;
    private UserRepository userRepository;

    @Autowired
    public CommunicationService(CommunicationRepository communicationRepository, UserRepository userRepository) {
        this.communicationRepository = communicationRepository;
        this.userRepository = userRepository;
    }

    public List<Communication> getCommunications(){
        return communicationRepository.findAll();
    }

    public Optional<Communication> getCommunicationById(Integer communicationId){
        return communicationRepository.findById(communicationId);
    }

    public void addNewCommunication(Communication communication, Integer receiverId, Integer senderId){
        communication.setReceiver(userRepository.getById(receiverId));
        communication.setSender(userRepository.getById(senderId));
        communicationRepository.save(communication);
    }

    public void deleteCommunication(Integer communicationId){
        boolean exists = communicationRepository.existsById(communicationId);
        if(!exists){
            throw new IllegalStateException("Communication with id" + communicationId + "does not exists." );
        }
        communicationRepository.deleteById(communicationId);
    }

    @Transactional
    public void updateCommunication(Integer communicationId, Communication communicationDetails){
        Communication communication = communicationRepository.findById(communicationId).orElseThrow(() -> new IllegalStateException(" Communication with id " + communicationId + " does not exists."));

        if(communicationDetails.getMessage() != null && communicationDetails.getMessage() != null && !Objects.equals(communication.getMessage(), communicationDetails.getMessage())){
            communication.setMessage(communicationDetails.getMessage());
        }

    }

}

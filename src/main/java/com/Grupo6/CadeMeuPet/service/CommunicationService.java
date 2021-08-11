package com.Grupo6.CadeMeuPet.service;

import com.Grupo6.CadeMeuPet.models.Communication;
import com.Grupo6.CadeMeuPet.models.UserApp;
import com.Grupo6.CadeMeuPet.repository.CommunicationRepository;
import com.Grupo6.CadeMeuPet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

}

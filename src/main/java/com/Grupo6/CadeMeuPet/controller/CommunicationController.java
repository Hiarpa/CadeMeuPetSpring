package com.Grupo6.CadeMeuPet.controller;

import com.Grupo6.CadeMeuPet.models.Communication;
import com.Grupo6.CadeMeuPet.service.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/chat")
public class CommunicationController {
    private final CommunicationService communicationService;

    @Autowired
    public CommunicationController(CommunicationService communicationService) {
        this.communicationService = communicationService;
    }

    @GetMapping
    public List<Communication> getCommunications(){
        return communicationService.getCommunications();
    }

    @GetMapping("/{communicationId}")
    public Optional<Communication> getCommunicationById(@PathVariable Integer communicationId){
        return communicationService.getCommunicationById(communicationId);
    }

    @PostMapping
    public void registerNewCommunication(@RequestBody Communication communication,
                                         @RequestParam Integer receiverId,
                                         @RequestParam Integer senderId){
        communicationService.addNewCommunication(communication, receiverId, senderId);
    }
}

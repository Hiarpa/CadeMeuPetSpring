package com.Grupo6.CadeMeuPet.models;

import javax.persistence.*;

@Entity @Table(name = "communication")
public class Communication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_communication")
    private Integer idCommunication;

    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "fk_id_sender")
    private UserApp sender;

    @ManyToOne
    @JoinColumn(name = "fk_id_receiver")
    private UserApp receiver;

    public Communication() {
    }

    public Communication(Integer idCommunication, String message) {
        this.idCommunication = idCommunication;
        this.message = message;
    }

    public Communication(String message, UserApp sender, UserApp receiver) {
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Communication(Integer idCommunication, String message, UserApp sender, UserApp receiver) {
        this.idCommunication = idCommunication;
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
    }

    public void sendMessage(){
    }

    public Integer getIdCommunication() {
        return idCommunication;
    }

    public void setIdCommunication(Integer idCommunication) {
        this.idCommunication = idCommunication;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserApp getSender() {
        return sender;
    }

    public void setSender(UserApp sender) {
        this.sender = sender;
    }

    public UserApp getReceiver() {
        return receiver;
    }

    public void setReceiver(UserApp receiver) {
        this.receiver = receiver;
    }
}

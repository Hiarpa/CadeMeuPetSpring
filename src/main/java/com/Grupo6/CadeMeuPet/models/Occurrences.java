package com.Grupo6.CadeMeuPet.models;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "occurrence")
public class Occurrences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_occurrence")
    private Integer idOccurrence;
    private Date dateFound;
    private Date dateLost;
    private String lostPlace;
    private String foundPlace;

    @ManyToOne
    @JoinColumn(name = "fk_id_pet")
    private Pets pet;

    @ManyToOne
    @JoinColumn(name = "fk_id_found_by_user")
    private UserApp foundByUser;

    @ManyToOne
    @JoinColumn(name = "fk_id_lost_by_user")
    private UserApp lostByUser;

    public Occurrences() {
    }

    //Found
    public Occurrences(Integer idOccurrence, Date dateFound, Pets pet, String foundPlace, UserApp foundByUser, UserApp lostByUser) {
        this.idOccurrence = idOccurrence;
        this.pet = pet;
        this.dateFound = dateFound;
        this.foundPlace = foundPlace;
        this.foundByUser = foundByUser;
        this.lostByUser = null;
    }
    //Lost
    public Occurrences(Integer idOccurrence, Date dateLost, Pets pet, String lostPlace, UserApp lostByUser) {
        this.idOccurrence = idOccurrence;
        this.dateLost = dateLost;
        this.pet = pet;
        this.lostPlace = lostPlace;
        this.lostByUser = lostByUser;
    }

    public Occurrences(Date dateFound, Date dateLost, Pets pet, String lostPlace, String foundPlace, UserApp foundByUser, UserApp lostByUser) {
        this.dateFound = dateFound;
        this.dateLost = dateLost;
        this.pet = pet;
        this.lostPlace = lostPlace;
        this.foundPlace = foundPlace;
        this.foundByUser = foundByUser;
        this.lostByUser = lostByUser;
    }

    public Occurrences(Integer idOccurrence, Date dateFound, Date dateLost, Pets pet, String lostPlace, String foundPlace, UserApp foundByUser, UserApp lostByUser) {
        this.idOccurrence = idOccurrence;
        this.dateFound = dateFound;
        this.dateLost = dateLost;
        this.pet = pet;
        this.lostPlace = lostPlace;
        this.foundPlace = foundPlace;
        this.foundByUser = foundByUser;
        this.lostByUser = lostByUser;
    }

   @Override
    public String toString() {
        return "Occurrences{" +
                "id=" + id +
                ", date_found=" + date_found +
                ", date_lost=" + date_lost +
                ", lost_place='" + lost_place + '\'' +
                ", found_place='" + found_place + '\'' +
                ", pet=" + pet +
                ", user_found_by=" + user_found_by +
                ", user_lost_by=" + user_lost_by +
                '}';
    }

    public void setIdOccurrence(Integer idOccurrence) {
        this.idOccurrence = idOccurrence;
    }

    public Date getDateFound() {
        return dateFound;
    }

    public void setDateFound(Date dateFound) {
        this.dateFound = dateFound;
    }

    public Date getDateLost() {
        return dateLost;
    }

    public void setDateLost(Date dateLost) {
        this.dateLost = dateLost;
    }

    public String getLostPlace() {
        return lostPlace;
    }

    public void setLostPlace(String lostPlace) {
        this.lostPlace = lostPlace;
    }

    public String getFoundPlace() {
        return foundPlace;
    }

    public void setFoundPlace(String foundPlace) {
        this.foundPlace = foundPlace;
    }

    public Pets getPet() {
        return pet;
    }

    public void setPet(Pets pet) {
        this.pet = pet;
    }

    public UserApp getFoundByUser() {
        return foundByUser;
    }

    public void setFoundByUser(UserApp foundByUser) {
        this.foundByUser = foundByUser;
    }

    public UserApp getLostByUser() {
        return lostByUser;
    }

    public void setLostByUser(UserApp lostByUser) {
        this.lostByUser = lostByUser;
    }
}
package com.Grupo6.CadeMeuPet.models;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "occurrence")
public class Occurrences {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "occurrences_pet")
    private Integer id;
    private String foundBy;
    private String lostBy;
    private Date data_found;
    private Date data_lost;
    private String pets;
    private String lost_place;
    private String found_place;

    @JoinColumn(name = "fk_id_user")
    private UserApp user;

    public Occurrences() {
    }

    public Occurrences(String foundBy, String lostBy, Date data_found, Date data_lost, String pets, String lost_place, String found_place) {
        this.foundBy = foundBy;
        this.lostBy = lostBy;
        this.data_found = data_found;
        this.data_lost = data_lost;
//        this.pets = pets;
        this.lost_place = lost_place;
        this.found_place = found_place;
    }

    public Occurrences(Integer id, String foundBy, String lostBy, Date data_found, Date data_lost, String pets, String lost_place, String found_place, String user) {
        this.id = id;
        this.foundBy = foundBy;
        this.lostBy = lostBy;
        this.data_found = data_found;
        this.data_lost = data_lost;
//        this.pets = pets;
        this.lost_place = lost_place;
        this.found_place = found_place;
//        this.user = user;
    }




    public Integer getUserId() {
        return id;
    }

    public String getFoundBy() {
        return foundBy;
    }

    public String getLostBy() {
        return lostBy;
    }

    public Date getFoundDate() {
        return data_found;
    }

    public Date getLostDAte() {
        return data_lost;
    }

//    public Pets getPets() { return pets; }

    public String getLost_place() {
        return lost_place;
    }

    public String getFound_place() {
        return found_place;
    }

    public void setUser(UserApp user) {
        this.user = user;
    }
}
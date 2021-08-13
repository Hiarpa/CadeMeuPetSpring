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
    private Date data_found;
    private Date data_lost;
    private String pets;
    private String lost_place;
    private String found_place;

    @JoinColumn(name = "fk_id_found_by")
    private UserApp user_found_by;

    @JoinColumn(name = "fk_id_lost_by")
    private UserApp user_lost_by;

    public Occurrences() {
    }

    public Occurrences(Date data_found, Date data_lost, String pets, String lost_place, String found_place) {

        this.data_found = data_found;
        this.data_lost = data_lost;
//        this.pets = pets;
        this.lost_place = lost_place;
        this.found_place = found_place;
    }

    public Occurrences(Integer id, Date data_found, Date data_lost, String lost_place, String found_place, UserApp user_found_by) {
        this.id = id;
        this.data_found = data_found;
        this.data_lost = data_lost;
        this.lost_place = lost_place;
        this.found_place = found_place;
        this.user_found_by = user_found_by;
    }

    public Occurrences(Integer id, Date data_found, Date data_lost, String lost_place, String found_place, UserApp user_lost_by) {
        this.id = id;
        this.data_found = data_found;
        this.data_lost = data_lost;
        this.lost_place = lost_place;
        this.found_place = found_place;
        this.user_lost_by = user_lost_by;
    }

    public Integer getUserId() {
        return id;
    }

    public Date getFoundDate() {
        return data_found;
    }

    public Date getLostDate() {
        return data_lost;
    }


    public String getLost_place() {
        return lost_place;
    }

    public String getFound_place() {
        return found_place;
    }

//    public void setUser(UserApp user) {
//        this.user = user;
//    }
}
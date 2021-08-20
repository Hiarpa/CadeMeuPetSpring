package com.Grupo6.CadeMeuPet.models;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "occurrence")
public class Occurrences {

    @Id
    @SequenceGenerator(name = "occurrence_sequence", sequenceName = "occurrence_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "occurrence_sequence")
    @Column(name = "id_ocurrence")
    private Integer id;
    private Date date_found;
    private Date date_lost;
    private String lost_place;
    private String found_place;

    @ManyToOne
    @JoinColumn(name = "fk_id_pet")
    private Pets pet;

    @ManyToOne
    @JoinColumn(name = "fk_id_found_by")
    private UserApp user_found_by;

    @ManyToOne
    @JoinColumn(name = "fk_id_lost_by")
    private UserApp user_lost_by;

    public Occurrences() {
    }

    //Found
    public Occurrences(Integer id, Date date_found, Pets pet, String found_place, UserApp user_found_by, UserApp user_lost_by) {
        this.id = id;
        this.pet = pet;
        this.date_found = date_found;
        this.found_place = found_place;
        this.user_found_by = user_found_by;
        this.user_lost_by = null;
    }
    //Lost
    public Occurrences(Integer id, Date date_lost, Pets pet, String lost_place, UserApp user_lost_by) {
        this.id = id;
        this.date_lost = date_lost;
        this.pet = pet;
        this.lost_place = lost_place;
        this.user_lost_by = user_lost_by;
    }

    public Occurrences(Date date_found, Date date_lost, Pets pet, String lost_place, String found_place, UserApp user_found_by, UserApp user_lost_by) {
        this.date_found = date_found;
        this.date_lost = date_lost;
        this.pet = pet;
        this.lost_place = lost_place;
        this.found_place = found_place;
        this.user_found_by = user_found_by;
        this.user_lost_by = user_lost_by;
    }

    public Occurrences(Integer id, Date date_found, Date date_lost, Pets pet, String lost_place, String found_place, UserApp user_found_by, UserApp user_lost_by) {
        this.id = id;
        this.date_found = date_found;
        this.date_lost = date_lost;
        this.pet = pet;
        this.lost_place = lost_place;
        this.found_place = found_place;
        this.user_found_by = user_found_by;
        this.user_lost_by = user_lost_by;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate_found() {
        return date_found;
    }

    public void setDate_found(Date date_found) {
        this.date_found = date_found;
    }

    public Date getDate_lost() {
        return date_lost;
    }

    public void setDate_lost(Date date_lost) {
        this.date_lost = date_lost;
    }

    public String getLost_place() {
        return lost_place;
    }

    public void setLost_place(String lost_place) {
        this.lost_place = lost_place;
    }

    public String getFound_place() {
        return found_place;
    }

    public void setFound_place(String found_place) {
        this.found_place = found_place;
    }

    public Pets getPet() {
        return pet;
    }

    public void setPet(Pets pet) {
        this.pet = pet;
    }

    public UserApp getUser_found_by() {
        return user_found_by;
    }

    public void setUser_found_by(UserApp user_found_by) {
        this.user_found_by = user_found_by;
    }

    public UserApp getUser_lost_by() {
        return user_lost_by;
    }

    public void setUser_lost_by(UserApp user_lost_by) {
        this.user_lost_by = user_lost_by;
    }
}
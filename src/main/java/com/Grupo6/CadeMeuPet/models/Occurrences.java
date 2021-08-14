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
    private Date data_found;
    private Date data_lost;
    private String lost_place;
    private String found_place;

    @JoinColumn(name = "fk_id_pet")
    private Pets pet;

    @JoinColumn(name = "fk_id_found_by")
    private UserApp user_found_by;

    @JoinColumn(name = "fk_id_lost_by")
    private UserApp user_lost_by;

    public Occurrences() {
    }

    //Found
    public Occurrences(Integer id, Date data_found, Pets pet, String found_place, UserApp user_found_by, UserApp user_lost_by) {
        this.id = id;
        this.pet = pet;
        this.data_found = data_found;
        this.found_place = found_place;
        this.user_found_by = user_found_by;
        this.user_lost_by = null;
    }
    //Lost
    public Occurrences(Integer id, Date data_lost, Pets pet, String lost_place, UserApp user_lost_by) {
        this.id = id;
        this.data_lost = data_lost;
        this.pet = pet;
        this.lost_place = lost_place;
        this.user_lost_by = user_lost_by;
    }

    public Occurrences(Date data_found, Date data_lost, Pets pet, String lost_place, String found_place, UserApp user_found_by, UserApp user_lost_by) {
        this.data_found = data_found;
        this.data_lost = data_lost;
        this.pet = pet;
        this.lost_place = lost_place;
        this.found_place = found_place;
        this.user_found_by = user_found_by;
        this.user_lost_by = user_lost_by;
    }

    public Occurrences(Integer id, Date data_found, Date data_lost, Pets pet, String lost_place, String found_place, UserApp user_found_by, UserApp user_lost_by) {
        this.id = id;
        this.data_found = data_found;
        this.data_lost = data_lost;
        this.pet = pet;
        this.lost_place = lost_place;
        this.found_place = found_place;
        this.user_found_by = user_found_by;
        this.user_lost_by = user_lost_by;
    }
}
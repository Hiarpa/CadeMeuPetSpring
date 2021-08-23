package com.Grupo6.CadeMeuPet.models;

import javax.persistence.*;
import java.sql.Date;

@Entity @Table(name = "pet")
public class Pets  {

    @Id
    @SequenceGenerator(name = "pets_sequence", sequenceName = "pets_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pets_sequence")
    @Column(name = "id_pet")
    private Integer idPet;
    private String name;
    private String typePet;
    private String image;
    private String gender;
    private String size;
    private String breed;
    private String species;
    private String register;
    private String color;
    private String fur;
    private String description;
    private String status;

    @ManyToOne
    @JoinColumn(name = "fk_id_user")
    private UserApp user;

    public Pets() {
    }

    public Pets(String name, String typePet, String image, String gender, String size, String breed, String species, String register, String color, String fur, String description, String status) {
        this.name = name;
        this.typePet = typePet;
        this.image = image;
        this.gender = gender;
        this.size = size;
        this.breed = breed;
        this.species = species;
        this.register = register;
        this.color = color;
        this.fur = fur;
        this.description = description;
        this.status = status;
    }

    public Pets(Integer idPet, String name, String typePet, String image, String gender, String size, String breed, String species, String register, String color, String fur, String description, String status, UserApp user) {
        this.idPet = idPet;
        this.name = name;
        this.typePet = typePet;
        this.image = image;
        this.gender = gender;
        this.size = size;
        this.breed = breed;
        this.species = species;
        this.register = register;
        this.color = color;
        this.fur = fur;
        this.description = description;
        this.status = status;
        this.user = user;
    }

    public String getStatus() {
        return status;
    }


    public String getTypePet() {
        return typePet;
    }

    public String getBreed() {
        return breed;
    }

    public String getSpecies() {
        return species;
    }

    public String getRegister() {
        return register;
    }

    public String getColor() {
        return color;
    }

    public String getFur() {
        return fur;
    }

    public String getDescription() {
        return description;
    }

    public Integer getIdPet() {
        return idPet;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getGender() {
        return gender;
    }

    public String getSize() {
        return size;
    }

    public UserApp getUser() {
        return user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setUser(UserApp user) {
        this.user = user;
    }

    public void setTypePet(String typePet) {
        this.typePet = typePet;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFur(String fur) {
        this.fur = fur;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


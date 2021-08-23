package com.Grupo6.CadeMeuPet.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

@Entity @Table(name = "user")
public class UserApp {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "name")
    private String name;
    @Column(name = "cpf")
    private int cpf;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone_number")
    private int phoneNumber;
    @Column(name = "birth_date")
    private java.sql.Date birthDate;
    @Column(name = "gender")
    private String gender;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name= "id_user")
    private List<Occurrences> occurences;

    public UserApp() {
    }

    public UserApp(Integer idUser, String name, int cpf, String email, String password, int phoneNumber, java.sql.Date birthDate, String gender) {
        this.idUser = idUser;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public UserApp(String name, int cpf, String email, String password, int phoneNumber, Date birthDate, String gender) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.gender = gender;
    }


    public void alterPet(Pets pet){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a attribute to modify: ");
        System.out.println("1-Name");
        System.out.println("2-Gender");
        System.out.println("3-Size");
        int opcao = scanner.nextInt();
        switch (opcao){
            case 1:
                System.out.println("Current name is: " + pet.getName() + ". Wanna change to ?");
                String newName = scanner.next();
                pet.setName(newName);
                break;
            case 2:
                System.out.println("Current gender is: " + pet.getGender() + ". Wanna change to ?");
                String newGender = scanner.next();
                pet.setGender(newGender);
                break;
            case 3:
                System.out.println("Current size is: " + pet.getSize() + ". Wanna change to ?");
                String newSize = scanner.next();
                pet.setSize(newSize);
                break;
        }
    }

    public Integer getIdUser() {
        return idUser;
    }

    public String getName() {
        return this.name;
    }

    public int getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public java.sql.Date getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDate(java.sql.Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Occurrences> getOccurences() {
        return occurences;
    }

    public void setOccurences(List<Occurrences> occurences) {
        this.occurences = occurences;
    }
}




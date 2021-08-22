package com.Grupo6.CadeMeuPet.models;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @SequenceGenerator(name = "address_sequence", sequenceName = "address_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    private Integer idAddress;
    private int cep;
    private String street;
    private int number;
    private String complement;
    private String state;

    @OneToOne
    @JoinColumn(name = "fk_id_user")
    private UserApp user;

    public Address(int cep, String street, int number, String complement, String state, UserApp user) {
        this.cep = cep;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.state = state;
        this.user = user;
    }
    public Address(int cep, String street, int number, String complement, String state) {
        this.cep = cep;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.state = state;
    }

    public Address(Integer idAddress, int cep, String street, int number, String complement, String state, UserApp user) {
        this.idAddress = idAddress;
        this.cep = cep;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.state = state;
        this.user = user;
    }

    public Address() {
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) { this.idAddress = idAddress; }

    public String getStreet() { return street; }

    public void setStreet(String street) { this.street = street; }

    public int getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }

    public String getComplement() { return complement; }

    public void setComplement(String complement) { this.complement = complement; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public UserApp getUser() {
        return user;
    }

    public void setUser(UserApp user) {
        this.user = user;
    }

}


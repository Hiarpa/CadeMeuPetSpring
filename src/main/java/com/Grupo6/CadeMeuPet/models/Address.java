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
    private String rua;
    private int numero;
    private String complemento;
    private String estado;

    @OneToOne
    @JoinColumn(name = "fk_id_user")
    private UserApp user;

    public Address(int cep, String rua, int numero, String complemento, String estado, UserApp user) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.estado = estado;
        this.user = user;
    }
    public Address(int cep, String rua, int numero, String complemento, String estado) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.estado = estado;
    }

    public Address(Integer idAddress, int cep, String rua, int numero, String complemento, String estado, UserApp user) {
        this.idAddress = idAddress;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.estado = estado;
        this.user = user;
    }

    public Address() {
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public int getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public UserApp getUser() {
        return user;
    }

    public void setUser(UserApp user) {
        this.user = user;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}


package com.Grupo6.CadeMeuPet.models;

import javax.persistence.*;
import java.sql.Date;

@Entity @Table(name = "pet")
public class Pets  {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id_pet")
    private Integer idPets;
    private String name;
    private String tipo_pet;
    private String imagem;
    private String gender;
    private String status;
    private String size;
    private String raca;
    private String especie;
    private String registro;
    private String cor;
    private String pelagem;
    private String descricao;
    @Column(name = "local_p")
    private String localP;
    @Column(name = "local_a")
    private String localA;
    @Column(name = "data_a")
    private java.sql.Date dataA;
    @Column(name = "data_p")
    private java.sql.Date dataP;

    @ManyToOne
    @JoinColumn(name = "fk_id_user")
    private UserApp user;

    public Pets() {
    }

    public Pets(String name, String tipo_pet, String imagem, String gender, String status, String size, String raca, String especie, String registro, String cor, String pelagem, String descricao, String localP, String localA, Date dataA, Date dataP) {
        this.name = name;
        this.tipo_pet = tipo_pet;
        this.imagem = imagem;
        this.gender = gender;
        this.status = status;
        this.size = size;
        this.raca = raca;
        this.especie = especie;
        this.registro = registro;
        this.cor = cor;
        this.pelagem = pelagem;
        this.descricao = descricao;
        this.localP = localP;
        this.localA = localA;
        this.dataA = dataA;
        this.dataP = dataP;
    }

    public Pets(Integer idPets, String name, String tipo_pet, String imagem, String gender, String status, String size, String raca, String especie, String registro, String cor, String pelagem, String descricao, String localP, String localA, Date dataA, Date dataP, UserApp user) {
        this.idPets = idPets;
        this.name = name;
        this.tipo_pet = tipo_pet;
        this.imagem = imagem;
        this.gender = gender;
        this.status = status;
        this.size = size;
        this.raca = raca;
        this.especie = especie;
        this.registro = registro;
        this.cor = cor;
        this.pelagem = pelagem;
        this.descricao = descricao;
        this.localP = localP;
        this.localA = localA;
        this.dataA = dataA;
        this.dataP = dataP;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Pets{" +
                "idPets=" + idPets +
                ", name='" + name + '\'' +
                ", tipo_pet='" + tipo_pet + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                ", size='" + size + '\'' +
                ", localP='" + localP + '\'' +
                ", localA='" + localA + '\'' +
                ", dataA=" + dataA +
                ", dataP=" + dataP +
                '}';
    }

    public void verificar_status(){
        System.out.println("Status do pet: " + getStatus());
        System.out.println("Local perdido: " + getLocalP());
        System.out.println("Local achado: " + getLocalA());
        return;
    }

    public String getTipo_pet() {
        return tipo_pet;
    }

    public String getRaca() {
        return raca;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRegistro() {
        return registro;
    }

    public String getCor() {
        return cor;
    }

    public String getPelagem() {
        return pelagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getIdPets() {
        return idPets;
    }

    public String getName() {
        return name;
    }

    public String getImagem() {
        return imagem;
    }

    public String getGender() {
        return gender;
    }

    public String getStatus() {
        return status;
    }

    public String getSize() {
        return size;
    }

    public String getLocalP() {
        return localP;
    }

    public String getLocalA() {
        return localA;
    }

    public java.sql.Date getDataA() {
        return dataA;
    }

    public java.sql.Date getDataP() {
        return dataP;
    }

    public UserApp getUser() {
        return user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLocalP(String localP) {
        this.localP = localP;
    }

    public void setLocalA(String localA) {
        this.localA = localA;
    }

    public void setUser(UserApp user) {
        this.user = user;
    }

    public void setTipo_pet(String tipo_pet) {
        this.tipo_pet = tipo_pet;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataA(Date dataA) {
        this.dataA = dataA;
    }

    public void setDataP(Date dataP) {
        this.dataP = dataP;
    }

}


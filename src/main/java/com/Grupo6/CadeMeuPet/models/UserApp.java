package com.Grupo6.CadeMeuPet.models;

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

    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private int cpf;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name = "telefone")
    private int telefone;
    @Column(name = "data_nascimento") @DateTimeFormat(pattern = "dd/MM/yyyy")
    private java.sql.Date dataNasc;
    @Column(name = "genero")
    private String genero;

    @OneToMany(mappedBy = "user")
    private List<Pets> listPets;

    @OneToOne(mappedBy = "user")
    private Address address;

    public UserApp() {
    }

    public UserApp(Integer idUser, String nome, int cpf, String email, String senha, int telefone, java.sql.Date dataNasc, String genero) {
        this.idUser = idUser;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.genero = genero;
    }

    public UserApp(String nome, int cpf, String email, String senha, int telefone, Date dataNasc, String genero) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.genero = genero;
    }

    public UserApp(String nome, int cpf, String email, String senha, int telefone, Date dataNasc, String genero, List<Pets> listPets, Address address) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.genero = genero;
        this.listPets = listPets;
        this.address = address;
    }

    public void addPet(Pets pet){
        listPets.add(pet);
    }

    public void deletePet(int id){
        listPets.remove(id);
    }

//    public void verListaPets(){
//        for(Pets valor: listPets){
//            for(int i = 1; i < listPets.size(); i++){
//                System.out.println("Nome: " + valor.getNome() + "\n"+
//                        "Tipo: " + valor.getTipo() + "\n" +
//                        "Genêro: " + valor.getGenero() + "\n" +
//                        "Status: " + valor.getStatus() + "\n" +
//                        "Porte: " + valor.getPorte() + "\n" +
//                        "Local Achado: " + valor.getLocalA() + "\n" +
//                        "Local Perdido: " + valor.getLocalP() + "\n" +
//                        "Data em que foi achado: " + valor.getDataA() + "\n" +
//                        "Data em que foi perdido: " + valor.getDataP() + "\n" +
//                        "Imagem: " + valor.getImagem() + "\n" );
//            }
//        }
//    }

    public void alterPet(Pets pet){
        Scanner scanner = new Scanner(System.in);

        System.out.println("O que você deseja alterar ? ");
        System.out.println("1-Nome");
        System.out.println("2-Gênero");
        System.out.println("3-Porte");
        int opcao = scanner.nextInt();
        switch (opcao){
            case 1:
                System.out.println("O nome atual do pet é " + pet.getNome() + ". Deseja alterar para qual ?");
                String newName = scanner.next();
                pet.setNome(newName);
                break;
            case 2:
                System.out.println("O gênero atual do pet é " + pet.getGenero() + ". Deseja alterar para qual ?");
                String newGaddresser = scanner.next();
                pet.setGenero(newGaddresser);
                break;
            case 3:
                System.out.println("O porte atual do pet é " + pet.getPorte() + ". Deseja alterar para qual ?");
                String newPorte = scanner.next();
                pet.setPorte(newPorte);
                break;
        }
    }

    public void formatarData(){
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        setDataNasc(Date.valueOf(formatar.format(getDataNasc())));
    }

    public Integer getIdUser() {
        return idUser;
    }

    public String getNome() {
        return this.nome;
    }

    public int getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getTelefone() {
        return telefone;
    }

    public java.sql.Date getDataNasc() {
        return dataNasc;
    }

    public String getGenero() {
        return genero;
    }

    public Address getAddress() {
        return address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setDataNasc(java.sql.Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}




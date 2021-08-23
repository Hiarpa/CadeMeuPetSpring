package com.Grupo6.CadeMeuPet.models;


import javax.persistence.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
    @Column(name = "telephone")
    private int telephone;
    @Column(name = "birth_date")
    private java.sql.Date birthDate;
    @Column(name = "gender")
    private String gender;

    public UserApp() {
    }

    public UserApp(Integer idUser, String name, int cpf, String email, String password, int telephone, java.sql.Date birthDate, String gender) {
        this.idUser = idUser;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public UserApp(String name, int cpf, String email, String password, int telephone, Date birthDate, String gender) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.birthDate = birthDate;
        this.gender = gender;
    }


//    public void addPet(Pets pet){
//        listPets.add(pet);
//    }
//
//    public void deletePet(int id){
//        listPets.remove(id);
//    }

//    public void verListaPets(){
//        for(Pets valor: listPets){
//            for(int i = 1; i < listPets.size(); i++){
//                System.out.println("Name: " + valor.getName() + "\n"+
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

    public void formatarData(){
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        setBirthDate(Date.valueOf(formatar.format(getBirthDate()
        )));
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

    public int getTelephone() {
        return telephone;
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

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setBirthDate(java.sql.Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}




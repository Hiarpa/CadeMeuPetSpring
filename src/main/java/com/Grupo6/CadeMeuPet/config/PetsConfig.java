//package com.Grupo6.CadeMeuPet.config;
//
//import com.Grupo6.CadeMeuPet.models.Pets;
//import com.Grupo6.CadeMeuPet.repository.PetsRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.sql.Date;
//import java.util.List;
//
//@Configuration
//public class PetsConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner2(PetsRepository petsRepository){
//        return args -> {
//            Pets pet1 = new Pets("Max","Cachorro","max.png","Masculino","Perdido","Médio","Dobermann",null,null,"Preto",null,null,"Parque Ibirapuera",null,  new Date(System.currentTimeMillis()),Date.valueOf("2021-08-23"));
//            Pets pet2 = new Pets("Mia","Gato","mia.png","Feminino","Achado","Pequeno","Siamês",null,null,"Caramelo",null,null,null,"Rua 4, Bairro Flores", Date.valueOf("2021-05-20"), new Date(System.currentTimeMillis()));
//            petsRepository.saveAll(
//                    List.of(pet1,pet2));
//        };
//    }
//}

package com.Grupo6.CadeMeuPet.config;

import com.Grupo6.CadeMeuPet.models.UserApp;
import com.Grupo6.CadeMeuPet.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args ->{
            UserApp user1 = new UserApp(1,"Hiarpa Neto", 3477445, "hiarpanetto@gmail.com", "9562",9272, Date.valueOf("2001-03-23"),"Masculino");
            UserApp user2 = new UserApp(2,"Thacio Moraes", 478944, "thacio_moraes@gmail.com", "0406",7821,Date.valueOf("1981-09-30"),"Masculino");
            repository.saveAll(
                    List.of(user1,user2)
            );
        };
    }
}

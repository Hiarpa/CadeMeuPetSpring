package com.Grupo6.CadeMeuPet.config;

import com.Grupo6.CadeMeuPet.models.Address;
import com.Grupo6.CadeMeuPet.models.UserApp;
import com.Grupo6.CadeMeuPet.repository.AddressRepository;
import com.Grupo6.CadeMeuPet.repository.UserRepository;
import com.Grupo6.CadeMeuPet.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class AddressConfig {

    @Bean
    CommandLineRunner commandLineRunner1(AddressRepository addressRepository, UserRepository userRepository){
        return args -> {
            Address a1 = new Address(697945455,"Rua 18",4,"Ao lado da Igreja Batista","Amazonas");
            Address a2 = new Address(976342428,"Rua Silva Bueno",20,"Perto do Mercadinho Barato","São Paulo");
            addressRepository.saveAll(
                    List.of(a1,a2));
        };
    }
}

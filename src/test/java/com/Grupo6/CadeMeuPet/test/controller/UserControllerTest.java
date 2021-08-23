package com.Grupo6.CadeMeuPet.test.controller;

import com.Grupo6.CadeMeuPet.models.UserApp;
import com.Grupo6.CadeMeuPet.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Date;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserApp.class)
@AutoConfigureMockMvc
@WithMockUser(username = "jhon.caet@gmail.com")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void callingUserByWrongIdShouldReturnNotFound() throws Exception{
        Optional<UserApp> userTest = Optional.of(new UserApp(3,"Jhonatan",69473234,"hiarpanetto@gmail.com","123praia",9648216,new Date(1999-05-20),"Masculino"));
        Mockito.when(userRepository.findById(5)).thenReturn(userTest);
        this.mockMvc.perform(
                get("/api/user")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void shouldReturnJustOneFromResult() throws Exception {
        UserApp userTest = new UserApp(1,"Jhonantan",69473234,"jhon.caet@gmail.com","123praia",9648216,new Date(1999-05-20),"Masculino");
        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(userTest));
        this.mockMvc.perform(
                get("/api/user/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}

package com.Grupo6.CadeMeuPet.security;

import com.Grupo6.CadeMeuPet.models.UserApp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager manager){
        this.authenticationManager = manager;
    }

    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) {
        try{
            UserApp user = new ObjectMapper().readValue(req.getInputStream(), UserApp.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(),
                            user.getPassword(), new ArrayList<>())
            );

        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}

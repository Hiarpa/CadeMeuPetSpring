package com.Grupo6.CadeMeuPet.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/secure")
public class SecuredController {

    @GetMapping
    public ResponseEntity reachSecureEndpoint(){
        ResponseEntity responseEntity = new ResponseEntity("Você está autenticado!", HttpStatus.OK);
        return responseEntity;
    }
}

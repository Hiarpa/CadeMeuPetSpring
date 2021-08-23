package com.Grupo6.CadeMeuPet.controller;

import com.Grupo6.CadeMeuPet.models.UserApp;
import com.Grupo6.CadeMeuPet.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(
            value = "Listar todos os usuarios cadastrados",
            response = UserApp.class,
            notes = "Esta operação retorna a lista de usuarios cadastrados"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna um List com um codigo 200",
                    response = UserApp.class
            ),
            @ApiResponse(
                    code = 401,
                    message = "Você não possui autorização para fazer essa solicitação"
            ),
            @ApiResponse(
                    code = 403,
                    message = "Token não autorizado"
            ),
            @ApiResponse(
                    code = 404,
                    message = "List não foi encontrada"
            ),
    })
    @GetMapping("/list")
    public List<UserApp> getUsers(){
        return userService.getUsers();
    }

    @ApiOperation(
            value = "Retorna o usuario cadastrado por id",
            response = UserApp.class,
            notes = "Esta operação retorna o usuario correspondente ao id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna um usuário com codigo 200",
                    response = UserApp.class
            ),
            @ApiResponse(
                    code = 401,
                    message = "Você não possui autorização para fazer essa solicitação"
            ),
            @ApiResponse(
                    code = 403,
                    message = "Token não autorizado"
            ),
            @ApiResponse(
                    code = 404,
                    message = "Usuário com este Id não foi encontrado"
            ),
    })
    @GetMapping("/list/search/{userId}")
    public Optional<UserApp> getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @ApiOperation(
            value = "Registrar um novo usuário",
            notes = "Esta operação cadastra um novo usuário no sistema."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Cadastra um novo usuário com 200"
            ),
            @ApiResponse(
                    code = 401,
                    message = "Você não possui autorização para fazer essa solicitação"
            ),
            @ApiResponse(
                    code = 403,
                    message = "Token não autorizado"
            ),
    })
    @PostMapping("/record")
    public void registerNewUser(@RequestBody UserApp user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.addNewUser(user);
    }

    @ApiOperation(
            value = "Deletar um usuário por id",
            notes = "Esta operação deleta um usuário correspondente ao id."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Deleta um usuário com 200"
            ),
            @ApiResponse(
                    code = 401,
                    message = "Você não possui autorização para fazer essa solicitação"
            ),
            @ApiResponse(
                    code = 403,
                    message = "Token não autorizado"
            ),
            @ApiResponse(
                    code = 404,
                    message = "Usuário com esse id não foi encontrado"
            )
    })
    @DeleteMapping(path = "/list/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
    }

    @ApiOperation(
            value = "Atualiza os dados de um usuário",
            notes = "Esta operação atualiza os dados de um usuario."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Atualiza um usuário com 200"
            ),
            @ApiResponse(
                    code = 401,
                    message = "Você não possui autorização para fazer essa solicitação"
            ),
            @ApiResponse(
                    code = 403,
                    message = "Token não autorizado"
            ),
            @ApiResponse(
                    code = 404,
                    message = "Usuário com esse id não foi encontrado"
            )
    })
    @PatchMapping(path = "/list/patch/{userId}")
    public void updateUser(@PathVariable("userId") Integer userId, @RequestBody UserApp userDetails){
        userService.updateUser(userId,userDetails);
    }
}

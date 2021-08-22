package com.Grupo6.CadeMeuPet.test.controller;

import com.Grupo6.CadeMeuPet.models.UserApp;
import com.Grupo6.CadeMeuPet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/user")
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
            response = User.class,
            notes = "Esta operação retorna a lista de usuarios cadastrados"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna um List com um codigo 200",
                    response = User.class
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

    @GetMapping
    public List<UserApp> getUsers(){
        return userService.getUsers();
    }

    @ApiOperation(
            value = "Retonar o usuario cadastrado por id",
            response = User.class,
            notes = "Esta operação retorna o usuario requisitado pelo usuário"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna um User com codigo 200",
                    response = User.class
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
                    message = "User com este Id não foi encontrado"
            ),
    })

    @GetMapping("/{userId}")
    public Optional<UserApp> getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @ApiOperation(
            value = "Registrar um novo User",
            notes = "Esta operação cadastra um novo User atribuindo a um usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Cadastra um novo User com 200"
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

    @PostMapping
    public void registerNewUser(@RequestBody UserApp user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.addNewUser(user);
    }
    @ApiOperation(
            value = "Deletar um User por id",
            notes = "Esta operação deleta um User com o id requisitado pelo usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Deleta um User com 200"
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
                    message = "User com esse id não foi encontrado"
            )
    })

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
    }

    @ApiOperation(
            value = "Atualiza os dados de um User",
            notes = "Esta operação atualiza o usuario de um User requisitado pelo usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Atualiza um User com 200"
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
                    message = "User com esse id não foi encontrado"
            )
    })

    @PatchMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Integer userId, @RequestBody UserApp userDetails){
        userService.updateUser(userId,userDetails);
    }
}

package com.Grupo6.CadeMeuPet.test.controller;

import com.Grupo6.CadeMeuPet.models.Communication;
import com.Grupo6.CadeMeuPet.service.CommunicationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "communication")
public class CommunicationController {
    private final CommunicationService communicationService;

    @Autowired
    public CommunicationController(CommunicationService communicationService) {
        this.communicationService = communicationService;
    }

    @ApiOperation(
            value = "Listar todas as comunicações cadastradas",
            response = Communication.class,
            notes = "Esta operação retorna a lista de comunicações cadastradas"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna um List com um codigo 200",
                    response = Communication.class
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
    public List<Communication> getCommunications(){
        return communicationService.getCommunications();
    }

    @ApiOperation(
            value = "Retonar a comunicação cadastrada por id",
            response = Communication.class,
            notes = "Esta operação retorna a comunicação requisitada pelo usuário"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna um Communication com codigo 200",
                    response = Communication.class
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
                    message = "Communication com este Id não foi encontrado"
            ),
    })

    @GetMapping("/{communicationId}")
    public Optional<Communication> getCommunicationById(@PathVariable Integer communicationId){
        return communicationService.getCommunicationById(communicationId);
    }

    @ApiOperation(
            value = "Registrar um novo Communication",
            notes = "Esta operação cadastra um novo Communication atribuindo a um usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Cadastra um novo Communication com 200"
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

    @PostMapping(path = "/register")
    public void registerNewCommunication(@RequestBody Communication communication,
                                         @RequestParam Integer receiverId,
                                         @RequestParam Integer senderId){
        communicationService.addNewCommunication(communication, receiverId, senderId);
    }

    @ApiOperation(
            value = "Deletar um Communication por id",
            notes = "Esta operação deleta um Communication com o id requisitado pelo usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Deleta um Communication com 200"
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
                    message = "Communication com esse id não foi encontrado"
            )
    })

    @DeleteMapping(path = "{communicationId}")
    public void deleteCommunication(@PathVariable("communicationId") Integer communicationId){
        communicationService.deleteCommunication(communicationId);
    }
  
    @ApiOperation(
            value = "Atualiza os dados de um Communication",
            notes = "Esta operação atualiza a comunicação de um Communication requisitado pelo usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Atualiza um Communication com 200"
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
                    message = "Communication com esse id não foi encontrado"
            )
    })

    @PatchMapping(path = "{communicationId}")
    public void updateCommunication(@PathVariable("communicationId") Integer communicationId, @RequestBody Communication communicationDetails){
        communicationService.updateCommunication(communicationId, communicationDetails);
    }
}

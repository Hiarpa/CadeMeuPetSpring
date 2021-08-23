package com.Grupo6.CadeMeuPet.controller;

import com.Grupo6.CadeMeuPet.models.Occurrences;
import com.Grupo6.CadeMeuPet.service.OccurrencesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/occurrences")
public class OccurrencesController {

    private final OccurrencesService occurrencesService;

    @Autowired
    private OccurrencesController(OccurrencesService occurrencesService) {
        this.occurrencesService = occurrencesService;
    }

    @ApiOperation(
            value = "Listar todos as ocorrencias cadastradas",
            response = Occurrences.class,
            notes = "Esta operação retorna a lista de ocorrencias cadastradas"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna um List com um codigo 200",
                    response = Occurrences.class
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
    public List<Occurrences> getOccurrences(){
        return occurrencesService.getOccurrences();
    }
  
    @ApiOperation(
            value = "Retorna a ocorrencia cadastrada por id",
            response = Occurrences.class,
            notes = "Esta operação retorna a ocorrencia requisitada pelo usuário"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna uma ocorrência com codigo 200",
                    response = Occurrences.class
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
                    message = "Ocorrência com este id não foi encontrado"
            ),
    })
    @GetMapping("/list/search/{occurrencesId}")
    public Optional<Occurrences> getOccurrencesById(@PathVariable Integer occurrencesId) {
        return occurrencesService.getOccurrencesById(occurrencesId);
    }


    @ApiOperation(
            value = "Registrar uma nova ocorrência para um Pet perdido",
            notes = "Esta operação cadastra uma ocorrência atribuindo a um pet e o usuário que perdeu o pet."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Cadastra novos ocorrência com 200"
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
    @PostMapping(path = "/record/petlost")
    public void registerNewOccurrenceLost(@RequestBody Occurrences occurrences, @RequestParam Integer userIdWhoLost, @RequestParam Integer petId){
        occurrencesService.addNewOccurrenceLost(occurrences, userIdWhoLost, petId);
    }

    @PostMapping(path = "/record/petfound")
    public void registerNewOccurrenceFound(@RequestBody Occurrences occurrences, @RequestParam Integer userIdWhoFound, @RequestParam Integer petId){
        occurrencesService.addNewOccurrenceFound(occurrences, userIdWhoFound, petId);
    }

    @ApiOperation(
            value = "Deletar uma ocorrência por id",
            notes = "Esta operação deleta ocorrência com o id requisitado pelo usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Deleta uma ocorrência com 200"
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
                    message = "Ocorrência com esse id não foi encontrado"
            )
    })

    @DeleteMapping(path = "/list/delete/{occurrencesId}")
    public void deleteOccurrences(@PathVariable("occurrencesId") Integer occurrencesId){
        occurrencesService.deleteOccurrences(occurrencesId);
    }

    @ApiOperation(
            value = "Atualiza os dados de um ocorrência",
            notes = "Esta operação atualiza a ocorrencia de um Occurrences requisitado pelo usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Atualiza uma ocorrência com 200"
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
                    message = "Ocorrência com esse id não foi encontrado"
            )
    })
    @PatchMapping(path = "/list/patch/{occurrencesId}")
    public void updateOccurrences(@PathVariable("occurrencesId") Integer occurrencesId, @RequestBody Occurrences occurrencesDetails){
        occurrencesService.updateOccurrences(occurrencesId, occurrencesDetails);
    }
}

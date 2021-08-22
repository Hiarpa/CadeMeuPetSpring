package com.Grupo6.CadeMeuPet.test.controller;

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
@RequestMapping(path = "occurrences")
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

    @GetMapping
    public List<Occurrences> getOccurrences(){
        return occurrencesService.getOccurrences();
    }

    @ApiOperation(
            value = "Retonar a ocorrencia cadastrada por id",
            response = Occurrences.class,
            notes = "Esta operação retorna a ocorrencia requisitada pelo usuário"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna um Occurrences com codigo 200",
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
                    message = "Occurrences com este Id não foi encontrado"
            ),
    })

    @GetMapping("/{occurrencesId}")
    public Optional<Occurrences> getOccurrencesById(@PathVariable Integer occurrencesId) {
        return occurrencesService.getOccurrencesById(occurrencesId);
    }

    @ApiOperation(
            value = "Registrar novos Occurrences",
            notes = "Esta operação cadastra novos Occurrences atribuindo a um usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Cadastra novos Occurrences com 200"
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
    public void registerNewOccurrences(@RequestBody Occurrences occurrences, @RequestParam Integer userId, @RequestParam Integer petId){

        occurrencesService.addNewOccurrences(occurrences, userId, petId);
    }
    @ApiOperation(
            value = "Deletar um Occurrences por id",
            notes = "Esta operação deleta Occurrences com o id requisitado pelo usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Deleta um Occurrences com 200"
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
                    message = "Occurrences com esse id não foi encontrado"
            )
    })

    @DeleteMapping(path = "{occurrencesId}")
    public void deleteOccurrences(@PathVariable("occurrencesId") Integer occurrencesId){
        occurrencesService.deleteOccurrences(occurrencesId);
    }

    @ApiOperation(
            value = "Atualiza os dados de um Occurrences",
            notes = "Esta operação atualiza a ocorrencia de um Occurrences requisitado pelo usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Atualiza um Occurrences com 200"
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
                    message = "Occurrences com esse id não foi encontrado"
            )
    })

    @PatchMapping(path = "{occurrencesId}")
    public void updateOccurrences(@PathVariable("occurrencesId") Integer occurrencesId, @RequestBody Occurrences occurrencesDetails){
        occurrencesService.updateOccurrences(occurrencesId, occurrencesDetails);
    }

}

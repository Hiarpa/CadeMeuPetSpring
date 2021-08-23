package com.Grupo6.CadeMeuPet.controller;

import com.Grupo6.CadeMeuPet.models.Pets;
import com.Grupo6.CadeMeuPet.service.PetsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/pet")
public class PetsController {

    private final PetsService petsService;

    @Autowired
    public PetsController(PetsService petsService) {
        this.petsService = petsService;
    }

    @ApiOperation(
            value = "Listar todos os pets cadastrados",
            response = Pets.class,
            notes = "Esta operação retorna a lista de pets cadastrados"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna um List com um codigo 200",
                    response = Pets.class
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
    public List<Pets> getPets(){
        return petsService.getPets();
    }

    @ApiOperation(
            value = "Retorna o pet cadastrado por id",
            response = Pets.class,
            notes = "Esta operação retorna o pet requisitado pelo usuário"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna um Pet com codigo 200",
                    response = Pets.class
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
                    message = "Pet com este Id não foi encontrado"
            ),
    })
    @GetMapping("/list/search/{petId}")
    public Optional<Pets> getPetsById(@PathVariable Integer petId){
        return petsService.getPetById(petId);
    }

    @ApiOperation(
            value = "Retorna uma lista de pets perdidos",
            response = Pets.class,
            notes = "Esta operação retorna pets perdidos"
    )
    @GetMapping("/list/search/lostpets")
    public List<Pets> getLostPets(){
        return petsService.getLostPets();
    }

    @ApiOperation(
            value = "Retorna uma lista de pets encontrados",
            response = Pets.class,
            notes = "Esta operação retorna pets encontrados"
    )
    @GetMapping("/list/search/foundpets")
    public List<Pets> getFoundPets(){
        return petsService.getFoundPets();
    }
    @ApiOperation(
            value = "Retorna uma lista de pets utilizando os filtros",
            response = Pets.class,
            notes = "Esta operação retorna uma lista de pets com os filtros selecionados pelo usuário"
    )
    @GetMapping("/list/filters")
    public List<Pets> getPetsWithFilter(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "size", required = false) String status
    ){
        return petsService.returnPetsWithFilter(type,status);
    }

    @ApiOperation(
            value = "Registrar um novo Pet",
            notes = "Esta operação cadastra um novo Pet atribuindo a um usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Cadastra um novo Pet com 200"
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
    @PostMapping(path = "/record")
    public void registerNewPet(@RequestBody Pets pet, @RequestParam Integer userId){
        petsService.addNewPet(pet,userId);
    }

    @ApiOperation(
            value = "Deletar um Pet por id",
            notes = "Esta operação deleta um Pet com o id requisitado pelo usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Deleta um Pet com 200"
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
                    message = "Pet com esse id não foi encontrado"
            )
    })
    @DeleteMapping(path = "/list/delete/{petId}")
    public void deletePet(@PathVariable("petId") Integer petId){
        petsService.deletePet(petId);
    }

    @ApiOperation(
            value = "Atualiza os dados de um Pet",
            notes = "Esta operação atualiza o nome, tipo e o genêro de um Pet requisitado pelo usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Atualiza um Pet com 200"
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
                    message = "Pet com esse id não foi encontrado"
            )
    })
  
    @PatchMapping(path = "/list/patch/{petId}")
    public void updatePet(@PathVariable("petId") Integer petId, @RequestBody Pets petDetails){
      petsService.updatePet(petId,petDetails);
    }
}

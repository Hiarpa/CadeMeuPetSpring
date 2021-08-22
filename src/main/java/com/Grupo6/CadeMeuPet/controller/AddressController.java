package com.Grupo6.CadeMeuPet.test.controller;

import com.Grupo6.CadeMeuPet.models.Address;
import com.Grupo6.CadeMeuPet.service.AddressService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    private AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @ApiOperation(
            value = "Listar todas os endereços cadastrados",
            response = Address.class,
            notes = "Esta operação retorna a lista de endereços cadastrados"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna um List com um codigo 200",
                    response = Address.class
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
    public List<Address> getAddress(){
        return addressService.getAddress();
    }

    @ApiOperation(
            value = "Retonar o endereço cadastrado por id",
            response = Address.class,
            notes = "Esta operação retorna o endereço requisitado pelo usuário"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna um Address com codigo 200",
                    response = Address.class
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
                    message = "Address com este Id não foi encontrado"
            ),
    })

    @GetMapping("/{addressId}")
    public Optional<Address> getAddressById(@PathVariable Integer addressId) {
        return addressService.getAddressById(addressId); }

    @ApiOperation(
            value = "Registrar um novo Address",
            notes = "Esta operação cadastra um novo Address atribuindo a um usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Cadastra um novo Address com 200"
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
    public void registerNewAddress(@RequestBody Address address, @RequestParam Integer userId){
        addressService.addNewAddress(address, userId);
    }

    @ApiOperation(
            value = "Deletar um Address por id",
            notes = "Esta operação deleta um Address com o id requisitado pelo usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Deleta um Address com 200"
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
                    message = "Address com esse id não foi encontrado"
            )
    })

    @DeleteMapping(path = "{addressId}")
    public void deleteAddress(@PathVariable("addressId") Integer addressId){
        addressService.deleteAddress(addressId);
    }
    @ApiOperation(
            value = "Atualiza os dados de um Address",
            notes = "Esta operação atualiza o endereço de um Address requisitado pelo usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Atualiza um Address com 200"
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
                    message = "Address com esse id não foi encontrado"
            )
    })
    @PatchMapping(path = "{addressId}")
    public void updateAddress(@PathVariable("addressId") Integer addressId, @RequestBody Address addressDetails) {
        addressService.updateAddress(addressId, addressDetails);
    }
}

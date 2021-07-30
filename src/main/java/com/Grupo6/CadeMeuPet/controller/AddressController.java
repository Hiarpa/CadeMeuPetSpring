package com.Grupo6.CadeMeuPet.controller;

import com.Grupo6.CadeMeuPet.models.Address;
import com.Grupo6.CadeMeuPet.service.AddressService;
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

    @GetMapping
    public List<Address> getAddress(){
        return addressService.getAddress();
    }

    @GetMapping("/{addressId}")
    public Optional<Address> getAddressById(@PathVariable Integer addressId) {
        return addressService.getAddressById(addressId);
    }

    //Colocar o userId como parametro
    @PostMapping
    public void registerNewAddress(@RequestBody Address address){
        addressService.addNewAddress(address);
    }

    @DeleteMapping(path = "{addressId}")
    public void deleteAddress(@PathVariable("addressId") Integer addressId){
        addressService.deleteAddress(addressId);
    }

    //@RequestBody
    @PutMapping(path = "{addressId}")
    public void updateAddress(
            @PathVariable("addressId") Integer addressId,
            @RequestParam(required = false) String rua,
            @RequestParam(required = false) int cep,
            @RequestParam(required = false) String estado,
            @RequestParam(required = false) int numero,
            @RequestParam(required = false) String complemento) {
        addressService.updateAddress(addressId, rua, cep, estado , numero, complemento );
    }
}

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


    @PostMapping
    public void registerNewAddress(@RequestBody Address address, @RequestParam Integer userId){
        addressService.addNewAddress(address, userId);
    }

    @DeleteMapping(path = "{addressId}")
    public void deleteAddress(@PathVariable("addressId") Integer addressId){
        addressService.deleteAddress(addressId);
    }

    @PatchMapping(path = "{addressId}")
    public void updateAddress(@PathVariable("addressId") Integer addressId, @RequestBody Address addressDetails) {
        addressService.updateAddress(addressId, addressDetails);
    }
}

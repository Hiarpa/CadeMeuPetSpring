package com.Grupo6.CadeMeuPet.service;

import com.Grupo6.CadeMeuPet.models.Address;
import com.Grupo6.CadeMeuPet.models.UserApp;
import com.Grupo6.CadeMeuPet.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddress(){
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(Integer addressId){
        return addressRepository.findById(addressId);
    }

    public void addNewAddress(Address address){
        Optional<Address> addressOptional = addressRepository.findAddressById(address.getIdAddress());
        if(addressOptional.isPresent()){
            throw new IllegalStateException("id already in use!!");
        }
        addressRepository.save(address);
    }

    public void deleteAddress(Integer addressId){
        boolean exists = addressRepository.existsById(addressId);
        if(!exists){
            throw new IllegalStateException("address with id " + addressId + " does not exists.");
        }
        addressRepository.deleteById(addressId);
    }
    @Transactional
    public void updateAddress(Integer addressId, String rua, int cep, String estado, int numero, String complemento){
        Address address = addressRepository.findById(addressId).orElseThrow(() -> new IllegalStateException(" address with id " + addressId + " does not exists."));

        if (rua != null && rua.length() > 0 && !Objects.equals(address.getRua(), rua)){
            address.setRua(rua);
        }
        if (estado != null && estado.length() > 0 && !Objects.equals(address.getEstado(), estado)){
            address.setEstado(estado);
        }
        if (complemento != null && complemento.length() > 0 && !Objects.equals(address.getComplemento(), complemento)){
            address.setEstado(complemento);
        }
        address.setCep(cep);
        address.setNumero(numero);
    }
}

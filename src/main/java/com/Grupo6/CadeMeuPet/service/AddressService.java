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
        Address addressOptional = addressRepository.findAddressById(address.getIdAddress());
//        if(addressOptional.isPresent()){
//            throw new IllegalStateException("id already in use!!");
//        }
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
    public void updateAddress(Integer addressId, Address addressDetails){
        Address address = addressRepository.findAddressById(addressId);

        if (addressDetails.getRua() != null && addressDetails.getRua().length() > 0 && !Objects.equals(address.getRua(), addressDetails.getRua())){
            address.setRua(addressDetails.getRua());
        }
        if (addressDetails.getEstado() != null && addressDetails.getEstado().length() > 0 && !Objects.equals(address.getEstado(), addressDetails.getEstado())){
            address.setEstado(addressDetails.getEstado());
        }
        if (addressDetails.getComplemento() != null && addressDetails.getComplemento().length() > 0 && !Objects.equals(address.getComplemento(), addressDetails.getComplemento())){
            address.setComplemento(addressDetails.getComplemento());
        }
        if(addressDetails.getCep() != 0){
            address.setCep(addressDetails.getCep());
        }
        if(addressDetails.getNumero() != 0){
            address.setNumero(addressDetails.getNumero());
        }
    }
}

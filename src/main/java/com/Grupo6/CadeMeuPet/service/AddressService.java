package com.Grupo6.CadeMeuPet.service;

import com.Grupo6.CadeMeuPet.models.Address;
import com.Grupo6.CadeMeuPet.models.UserApp;
import com.Grupo6.CadeMeuPet.repository.AddressRepository;
import com.Grupo6.CadeMeuPet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository, UserRepository userRepository){
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public List<Address> getAddress(){
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(Integer addressId){
        return addressRepository.findById(addressId);
    }

    public void addNewAddress(Address address, Integer userId){
        UserApp user = userRepository.getById(userId);
//        user.setAddress(address);
        address.setUser(user);
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

package com.Grupo6.CadeMeuPet.service;

import com.Grupo6.CadeMeuPet.models.UserApp;
import com.Grupo6.CadeMeuPet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserApp> getUsers(){
        return userRepository.findAll();
    }

    public Optional<UserApp> getUserById(Integer userId){
        return userRepository.findById(userId);
    }

    public void addNewUser(UserApp user){
//        Optional<UserApp> userAppOptional = userRepository.findUserByEmail(user.getEmail());
//        if(userAppOptional.isPresent()){
//            throw new IllegalStateException("email already in use!!");
//        }
        userRepository.save(user);
    }

    public void deleteUser(Integer userId){
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException("user with id " + userId + " does not exists.");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Integer userId, UserApp userDetails){
        UserApp user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException(" user with id " + userId + " does not exists."));

        if (userDetails.getEmail() != null && userDetails.getEmail().length() > 0 && !Objects.equals(user.getEmail(), userDetails.getEmail())){
            user.setEmail(userDetails.getEmail());
        }
        if (userDetails.getGender() != null && userDetails.getGender().length() > 0 && !Objects.equals(user.getGender(), userDetails.getGender())){
            user.setGender(userDetails.getGender());
        }
        if(userDetails.getTelephone() != 0){
            user.setTelephone(userDetails.getTelephone());
        }
        if(userDetails.getBirthDate() != null ){
            user.setBirthDate(userDetails.getBirthDate());
        }
    }
}

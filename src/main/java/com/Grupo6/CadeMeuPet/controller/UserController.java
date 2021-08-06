package com.Grupo6.CadeMeuPet.controller;

import com.Grupo6.CadeMeuPet.models.Pets;
import com.Grupo6.CadeMeuPet.models.UserApp;
import com.Grupo6.CadeMeuPet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserApp> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public Optional<UserApp> getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public void registerNewUser(@RequestBody UserApp user){
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
    }

    @PatchMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Integer userId, @RequestBody UserApp userDetails){
        userService.updateUser(userId,userDetails);
    }
}

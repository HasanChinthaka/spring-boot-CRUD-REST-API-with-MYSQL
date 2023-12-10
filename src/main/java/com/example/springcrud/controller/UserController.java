package com.example.springcrud.controller;

import com.example.springcrud.dto.UserDTO;
import com.example.springcrud.entity.User;
import com.example.springcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user){
        userService.addUser(user);

        return "success add user";
    }

    @GetMapping()
    public List<User> getuser(){
        return userService.getUsers();
    }

    @GetMapping("/get")
    public User getUser(@RequestParam Integer id){
        return userService.getUsers(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody User user){
        userService.updateUser(id, user);
        return  ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/update-name/{id}")
    public ResponseEntity<Void> updateName(@PathVariable Integer id, @RequestBody UserDTO userDTO){
        userService.updateName(id, userDTO);
        return  ResponseEntity.noContent().build();
    }
}

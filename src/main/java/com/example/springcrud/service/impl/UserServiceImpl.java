package com.example.springcrud.service.impl;

import com.example.springcrud.dto.UserDTO;
import com.example.springcrud.entity.User;
import com.example.springcrud.repository.UserRepository;
import com.example.springcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUsers(Integer id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User Id"+id));
        return user;
    }

    @Override
    public void updateUser(Integer id, User user) {
        //check weather the user is in database or not
        userRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User Id"+id));
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        //check weather the user is in database or not
        User user = userRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User Id"+id));
        userRepository.delete(user);
    }

    @Override
    public void updateName(Integer id, UserDTO userDTO) {
        User user = userRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User Id"+id));

        user.setName(userDTO.getName());

        userRepository.save(user);
    }
}

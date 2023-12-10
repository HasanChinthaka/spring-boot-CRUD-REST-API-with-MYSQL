package com.example.springcrud.service;

import com.example.springcrud.dto.UserDTO;
import com.example.springcrud.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getUsers();

    User getUsers(Integer id);

    void updateUser(Integer id, User user);

    void deleteUser(Integer id);

    void updateName(Integer id, UserDTO userDTO);
}

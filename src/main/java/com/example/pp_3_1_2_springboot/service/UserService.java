package com.example.pp_3_1_2_springboot.service;

import com.example.pp_3_1_2_springboot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void deleteUserById(int id);

    void updateUserById(int id, User user);

    User getUserById(int id);

    void addUser(User user);
}

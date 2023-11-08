package com.example.pp_3_1_2_springboot.service;

import org.springframework.stereotype.Service;
import com.example.pp_3_1_2_springboot.dao.UserDao;
import  com.example.pp_3_1_2_springboot.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers().stream()
                .sorted(Comparator.comparingInt(User::getId))
                .toList();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void updateUserById(int id, User user) {
        userDao.updateUserById(id, user);
    }
}

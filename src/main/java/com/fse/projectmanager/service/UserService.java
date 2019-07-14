package com.fse.projectmanager.service;

import com.fse.projectmanager.entity.User;
import com.fse.projectmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User addUser(User user) {
           return  userRepo.save(user);
    }

    public List<User> viewUsers() {
        return userRepo.findAll();
    }

    public String deleteUser(Integer userId) {
        try {
            userRepo.deleteById(userId);
            return "User deleted successfully";
        } catch (Exception e) {
            return "Error while deleting user";
        }
    }


}

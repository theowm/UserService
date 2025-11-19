package me.theowm.usermicroservice.services;

import me.theowm.usermicroservice.entities.User;

import java.util.List;
import java.util.UUID;

public interface UserServiceInterface {
    List<User> fetchAllUsers();
    User addNewUser(User user);
    User updateUser(UUID id, User user);
    void deleteUser(UUID id);

}

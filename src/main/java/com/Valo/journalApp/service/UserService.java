package com.Valo.journalApp.service;

import com.Valo.journalApp.entity.User;
import com.Valo.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User user){
        userRepository.save(user);
    }

    public List<User> getEntries(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId objectId){
        return userRepository.findById(objectId);
    }

    public void deleteById(ObjectId objectId){
        userRepository.deleteById(objectId);
    }

    public List<User> saveAllEntries(List<User> users) {
        return userRepository.saveAll(users);
    }

    public User findUserByUsername(String userName){
        return userRepository.findUserByUserName(userName);

    }


}

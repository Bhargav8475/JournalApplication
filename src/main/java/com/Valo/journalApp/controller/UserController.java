package com.Valo.journalApp.controller;

import com.Valo.journalApp.entity.Journal;
import com.Valo.journalApp.entity.User;
import com.Valo.journalApp.service.JournalService;
import com.Valo.journalApp.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return  userService.getEntries();
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.saveEntry(user);
    }

    @PutMapping("/{userName}")
    public void updateUser(@RequestBody User user, @PathVariable String userName){
        User oldUser = userService.findUserByUsername(userName);
        if(oldUser!=null) {
            oldUser.setUserName(user.getUserName());
            oldUser.setPassword(user.getPassword());
            userService.saveEntry(oldUser);
        }
    }





}

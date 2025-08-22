package com.Valo.journalApp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class StatusCheck {
    @GetMapping("/status")
    public String status(){
        return "200 OK";
    }
}

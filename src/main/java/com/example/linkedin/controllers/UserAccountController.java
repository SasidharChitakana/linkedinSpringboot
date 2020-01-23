package com.example.linkedin.controllers;

import com.example.linkedin.Services.UserAccountService;
import com.example.linkedin.entity.UserAccount;
import com.example.linkedin.models.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class UserAccountController {

    @Autowired
    UserAccountService userAccountService;

    @CrossOrigin(origins = "http://192.168.0.129:4200/")
    @PostMapping(path = "/login")
    public ResponseEntity<Object> Login(@RequestBody Login login) {
        return userAccountService.login(login);
    }

    @CrossOrigin(origins = "http://192.168.0.129:4200")
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Object> register(@RequestBody UserAccount userAccount) {

        return userAccountService.register(userAccount);

    }

}
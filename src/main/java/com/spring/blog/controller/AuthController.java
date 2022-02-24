package com.spring.blog.controller;

import com.spring.blog.dto.AuthenticationResponse;
import com.spring.blog.dto.LoginRequest;
import com.spring.blog.dto.RegisterRequest;
import com.spring.blog.exception.UserNameCantBeNull;
import com.spring.blog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        if(registerRequest.getUsername()==null)
        {
         throw new UserNameCantBeNull("UserName Cant be null");
        }
        authService.signup(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
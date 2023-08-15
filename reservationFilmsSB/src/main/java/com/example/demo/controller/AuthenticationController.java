package com.example.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AuthenticationRequest;
import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.dto.RegistrationRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthenticationService;

import java.util.List;


@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/v1/reservationsFilms/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private  final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegistrationRequest request)
    {
      return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register( @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/listerUser")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
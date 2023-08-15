package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor

public class TestController {
	private final UserRepository repository;
	@GetMapping("/lister")
	public List<User> listAllsers(){
		return repository.findAll();	}
@GetMapping("/chercherById/{id}")
public User findById(@PathVariable Long id) {
	return repository.findById(id).get(); }

}

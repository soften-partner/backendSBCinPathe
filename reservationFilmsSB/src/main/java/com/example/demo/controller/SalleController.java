package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SalleDTO;
import com.example.demo.service.SalleServiceImplementation;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

	@RestController
	@CrossOrigin(origins = "*")
	@RequestMapping("/api/v1/GestionSallesByAdmin/auth")
	@RequiredArgsConstructor
	public class SalleController {
		@Autowired
		private SalleServiceImplementation service;
		
		
		    
		@PostMapping("/addSalle")
	    public SalleDTO save(@RequestBody SalleDTO salleDto) {

	        return service.addSalle(salleDto);
	    }
		@GetMapping("/findById/{id}")
		    public SalleDTO findById(@PathVariable Long id) {
		        return service.findById(id);
		    }
		@DeleteMapping("/deleteById/{id}")
		    public void deleteById(@PathVariable Long id) {
		        service.deleteById(id);
		    }
		@GetMapping("findAll")
		    public List<SalleDTO> findAll() {
		        return service.findAll();
		    }
		
		   @PutMapping("updateSalle/{id}")
		    public SalleDTO updateSalle(@PathVariable Long id, @RequestBody SalleDTO salleDTO) {
		        return service.updateSalle(id, salleDTO);
		    }
	}





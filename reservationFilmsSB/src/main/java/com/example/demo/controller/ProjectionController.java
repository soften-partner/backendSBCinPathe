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

import com.example.demo.dto.ProjectionDTO;
import com.example.demo.service.IProjectionService;
import com.example.demo.service.ProjectionServiceImplementation;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/GestionProjecionByAdmin/auth")
@RequiredArgsConstructor


public class ProjectionController {


	@Autowired
	private IProjectionService service;
	
	
	    
	@PostMapping("/addProjection")
    public ProjectionDTO save(@RequestBody ProjectionDTO projectionDto) {

        return service.addProjection(projectionDto);
    }
	@GetMapping("/findById/{id}")
	    public ProjectionDTO findById(@PathVariable Long id) {
	        return service.findById(id);
	    }
	@DeleteMapping("/deleteById/{id}")
	    public void deleteById(@PathVariable Long id) {
	        service.deleteById(id);
	    }
	@GetMapping("findAll")
	    public List<ProjectionDTO> findAll() {
	        return service.findAll();
	    }
	
	   @PutMapping("updateProjection/{id}")
	    public ProjectionDTO updateProjection(@PathVariable Long id, @RequestBody ProjectionDTO projectionDTO) {
	        return service.updateProjection(id, projectionDTO);
	    }
}



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

import com.example.demo.dto.FilmDTO;
import com.example.demo.service.FilmServiceImplemeptation;
import com.example.demo.service.IFilmService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/GestionFilmsByAdmin/auth")
@RequiredArgsConstructor
public class FilmController {
	@Autowired
	private IFilmService servicefilm;
	
	
	    
	@PostMapping("/addFilm")
    public FilmDTO addFilm(@RequestBody FilmDTO filmDTO) {

        return servicefilm.addFilm(filmDTO);
    }
	@GetMapping("/findById/{id}")
	    public FilmDTO findById(@PathVariable Long id) {
	        return servicefilm.findById(id);
	    }
	@DeleteMapping("/deleteById/{id}")
	    public void deleteById(@PathVariable Long id) {
		servicefilm.deleteById(id);
	    }
	@GetMapping("findAll")
	    public List<FilmDTO> findAll() {
	        return servicefilm.findAll();
	    }
	
	   @PutMapping("updateFilm/{id}")
	    public FilmDTO updateFilm(@PathVariable Long id, @RequestBody FilmDTO filmDTO) {
	        return servicefilm.updateFilm(id, filmDTO);
	    }
}



package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.dto.ReservationDTO;
import com.example.demo.service.IFilmService;
import com.example.demo.service.IReservationService;

import lombok.RequiredArgsConstructor;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/GestionReservationByAdmin/auth")
@RequiredArgsConstructor
public class ReservationController {
	@Autowired
	private IReservationService serviceReservation;
	
	
	    
	@PostMapping("/addReservation")
    public ReservationDTO addReservation(@RequestBody ReservationDTO reservationDTO) {

        return serviceReservation.addReservation(reservationDTO);
    }
	@GetMapping("/findById/{id}")
	    public ReservationDTO findById(@PathVariable Long id) {
	        return serviceReservation.findById(id);
	    }
	@DeleteMapping("/deleteById/{id}")
	    public void deleteById(@PathVariable Long id) {
		serviceReservation.deleteById(id);
	    }
	@GetMapping("findAll")
	    public List<ReservationDTO> findAll() {
	        return serviceReservation.findAll();
	    }
	
	   @PutMapping("updateReservation/{id}")
	    public ReservationDTO updateReservation(@PathVariable Long id, @RequestBody ReservationDTO reservationDTO) {
	        return serviceReservation.updateResevation(id, reservationDTO);
	    }
}


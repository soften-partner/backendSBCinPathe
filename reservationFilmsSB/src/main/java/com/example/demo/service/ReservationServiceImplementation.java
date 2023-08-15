package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.dto.SalleDTO;
import com.example.demo.entity.Reservation;
import com.example.demo.entity.Salle;
import com.example.demo.repository.ReservationRepository;
@Service
public class ReservationServiceImplementation implements IReservationService{
@Autowired
 private ReservationRepository repository;
	@Override
	public ReservationDTO addReservation(ReservationDTO reservationDTO) {
         Reservation reservation = ReservationDTO.toEntity(reservationDTO);
        Reservation reservationSaved= repository.save(reservation);
        return ReservationDTO.fromEntity(reservationSaved);
	}

	@Override
	public ReservationDTO findById(Long id) {
	      Optional<Reservation> optionalReservation =repository.findById(id);
	        if (optionalReservation.isPresent()) {
	            Reservation reservation =optionalReservation.get();
	            return ReservationDTO.fromEntity(reservation);
	        }
	        else {
	            return null;
	        }
	    }

	@Override
	public void deleteById(Long id) {
		  repository.deleteById(id);
    }

	@Override
	public List<ReservationDTO> findAll() {
		  return repository.findAll().stream().map(ReservationDTO::fromEntity).collect(Collectors.toList());
    }

	@Override
	public ReservationDTO updateResevation(Long id, ReservationDTO reservationDTO) {
		 Optional<Reservation> existingReservation= repository.findById(id);
	        if (existingReservation.isPresent()) {
	            Reservation updatedReservation = existingReservation.get();
	            updatedReservation.setDateReservation(reservationDTO.getDateReservation());
	            updatedReservation.setNbPlaces(reservationDTO.getNbPlaces());
	            // Mettre à jour d'autres propriétés de l'utilisateur si nécessaire
	            Reservation savedReservation = repository.save(updatedReservation);

	            ReservationDTO savedReservationDTO = new ReservationDTO();
	            savedReservationDTO.setIdReservation(savedReservation.getIdReservation());
	            savedReservationDTO.setDateReservation(savedReservation.getDateReservation());
	            savedReservationDTO.setNbPlaces(savedReservation.getNbPlaces());
	            // Copier d'autres propriétés de l'utilisateur si nécessaire

	            return savedReservationDTO;
	        }
	        return null; // Gérer le cas où l'utilisateur n'est pas trouvé
	    }
	

	
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProjectionDTO;
import com.example.demo.dto.ReservationDTO;

public interface IReservationService {
	ReservationDTO addReservation(ReservationDTO reservationDTO);
	ReservationDTO findById (Long id);
    void deleteById (Long id);
    List<ReservationDTO> findAll();
    ReservationDTO updateResevation(Long id, ReservationDTO reservationDTO);
}



package com.example.demo.dto;

import java.util.Date;

import com.example.demo.entity.Reservation;
import com.example.demo.entity.Salle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationDTO {


	 private Long idReservation;
	    private int nbPlaces;
	    private String dateReservation;
	

public static Reservation toEntity (ReservationDTO dto){ 
	  return Reservation.builder()
			  .nbPlaces(dto.getNbPlaces())
			  .dateReservation(dto.getDateReservation())
			  .build(); }

	public static ReservationDTO fromEntity (Reservation reservation){
			return ReservationDTO.builder()
			.idReservation(reservation.getIdReservation())
			  .nbPlaces(reservation.getNbPlaces())
			  .dateReservation(reservation.getDateReservation()) 
			  .build(); } }

package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Salle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long idSalle ;
	private int nbrPlaces ; 
	private String nomSalle; 
	
	   @OneToMany(mappedBy = "salle")
	    private List<Reservation> reservations;
	   
	   @OneToMany(mappedBy = "salle")
	    private List<Projection> projections;

}

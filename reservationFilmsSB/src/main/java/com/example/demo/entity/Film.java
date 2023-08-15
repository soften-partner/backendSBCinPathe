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
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long idFilm ;
	private String nomFilm; 
	private String dureeFilm; 
	private String createur;
	private String description; 
	private boolean actif; 
	private String category;
	private String image ; 
	
	@OneToMany(mappedBy = "film")
    private List<Projection> projections;
	

	
}

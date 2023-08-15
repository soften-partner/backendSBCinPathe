
  package com.example.demo.dto;
  import com.example.demo.entity.Film;
  
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
  public class FilmDTO {
  
 
  
  private Long idFilm ;
  private String nomFilm;
  private String dureeFilm;
  private String createur;
  private String description;
  private boolean actif; 
	private String category;
	private String image ; 

  public static Film toEntity (FilmDTO dto){
	  return Film.builder()
			  .nomFilm(dto.getNomFilm())
			  .dureeFilm(dto.getNomFilm())
			  .createur(dto.getCreateur())
			  .description(dto.getDescription()) 
			  .category(dto.getCategory())
			  .image(dto.getImage())
			  .actif(dto.isActif())
			  .build(); }
  
  public static FilmDTO fromEntity (Film film){ 
	  return FilmDTO.builder()
			  .nomFilm(film.getNomFilm()) 
			  .dureeFilm(film.getNomFilm())
			  .createur(film.getCreateur()) 
			  .description(film.getDescription())
			  .category(film.getCategory())
			  .image(film.getImage())
			  .actif(film.isActif())

			  .build(); } }
  
 
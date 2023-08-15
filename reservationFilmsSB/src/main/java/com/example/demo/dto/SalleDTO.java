
  package com.example.demo.dto;
  
  import javax.persistence.Entity;
  import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType;
  import javax.persistence.Id;
  
  import com.example.demo.entity.Salle; 
  
  import lombok.AllArgsConstructor; import lombok.Builder; import
  lombok.Getter; import lombok.NoArgsConstructor; import lombok.Setter;
  
  
  @Getter
  
  @Setter
  
  @AllArgsConstructor
  
  @NoArgsConstructor
  
  @Builder public class SalleDTO {
  
private  Long idSalle ;


  private int nbrPlaces ;
  private String nomSalle;
  
  public static Salle toEntity (SalleDTO dto){ 
	  return Salle.builder()
  .nbrPlaces(dto.getNbrPlaces())
  .nomSalle(dto.getNomSalle()) 
  .build(); }
  
  public static SalleDTO fromEntity (Salle salle){
	  return SalleDTO.builder()
  .idSalle(salle.getIdSalle()) 
  .nbrPlaces(salle.getNbrPlaces())
  .nomSalle(salle.getNomSalle()) 
  .build(); } }
 
 
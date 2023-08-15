
  package com.example.demo.dto;
  
  import java.util.Date;  
  import com.example.demo.entity.Projection;

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
  public class ProjectionDTO {
	  private  Long idProjection ;
		private Date dateProjection; 
		private String tarifProjection ;

  
		 public static Projection toEntity (ProjectionDTO dto){
			 return Projection.builder()
			   .dateProjection(dto.getDateProjection())
			   .tarifProjection(dto.getTarifProjection())
			   .build(); }
			   
			   public static ProjectionDTO fromEntity (Projection projection){ 
			 	  return ProjectionDTO.builder()
			   .idProjection(projection.getIdProjection()) 
			   .dateProjection(projection.getDateProjection()) 
			   .tarifProjection(projection.getTarifProjection()) 
			   .build(); } 
			  
}
 
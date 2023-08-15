
  package com.example.demo.dto;
  
  
  import javax.persistence.EnumType; import javax.persistence.Enumerated;
  import javax.persistence.GeneratedValue; import
  javax.persistence.GenerationType; import javax.persistence.Id;

import com.example.demo.entity.ERole;
import com.example.demo.entity.Role;
  
  
  import lombok.AllArgsConstructor; import lombok.Builder; import
  lombok.Getter; import lombok.NoArgsConstructor; import lombok.Setter;
  
  @Getter
  
  @Setter
  
  @NoArgsConstructor
  
  @AllArgsConstructor
  
  @Builder public class RoleDTO {
	    private Long id;
	    private String name;


  
  public static Role toEntity (RoleDTO dto){
	  return Role.builder()
			  .name(dto.getName()) .build(); }
  
  public static RoleDTO fromEntity (Role role){ 
	  return RoleDTO.builder()
			  .name(role.getName()) .build(); }
  
  }
 
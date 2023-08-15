package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

import com.example.demo.entity.User;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationRequest {
	 private Long id; 
	 private String fullname;
	 private String password;
	 private String email;
	 private String lastName;
	 private Date dateCreation ; 
	 private Date dateUpdate ; 
	 private Date dateNaissance; 
	private Set<String> roles ;

    // methode de mappage
    
 // mapping de DTO 
    public static User toEntity (RegistrationRequest request){
   return User.builder()
     .fullname(request.getFullname())
     .password(request.getPassword())
     .lastName(request.getLastName())
     .email(request.getEmail()) 
     .dateNaissance(request.getDateNaissance())
     .dateCreation(request.getDateCreation())
     .dateUpdate(request.getDateUpdate())

     .build(); }
     
/* on n'a pas besoin de retour registrtiob
 * public static UserDTO fromEntity (User user){ return UserDTO.builder()
 * .id(user.getId()) .fullname(user.getFullname()) .password(user.getPassword())
 * .lastName(user.getLastName()) .dateNaissance(user.getDateNaissance())
 * .dateCreation(user.getDateCreation()) .dateUpdate(user.getDateUpdate())
 * .email(user.getEmail()) .build(); }
 */
    
}
    

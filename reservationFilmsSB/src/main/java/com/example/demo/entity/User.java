package com.example.demo.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User  implements UserDetails  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullname;
    private String password;
    private String email;
    private String lastName;
    private Date dateNaissance; 
   // private String role; 
    private Date dateCreation ; 
    private Date dateUpdate ; 
   
// relation user role 
    @ManyToMany(fetch = FetchType.EAGER)
	/*
	 * @JoinTable( name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
	 * inverseJoinColumns = @JoinColumn(name = "roles_id"))
	 */
    private Set<Role> roles = new HashSet<>();
// relation user reservation 
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = this.roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


import java.util.HashSet;
import java.util.Set;
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true) // une seule role
    private String name;
	/*
	 * @ManyToMany(fetch = FetchType.EAGER) private Set<User> users=new HashSet<>();
	 */
    

}

package com.example.demo.repository;

import org.springdoc.core.providers.JavadocProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Film;
@Repository
public interface FilmRepository  extends JpaRepository<Film, Long>{

}

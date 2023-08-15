package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.FilmDTO;

public interface IFilmService {

	FilmDTO addFilm(FilmDTO filmDTO);
  	FilmDTO findById (Long id);
    void deleteById (Long id);
    List<FilmDTO> findAll();
    FilmDTO updateFilm(Long id, FilmDTO filmDTO);
}

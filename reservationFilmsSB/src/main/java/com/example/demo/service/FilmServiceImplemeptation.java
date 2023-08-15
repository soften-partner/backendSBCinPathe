package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FilmDTO;
import com.example.demo.dto.SalleDTO;
import com.example.demo.entity.Film;
import com.example.demo.entity.Salle;
import com.example.demo.repository.FilmRepository;

@Service
public class FilmServiceImplemeptation implements IFilmService{
	@Autowired
    private FilmRepository repositoryFilm;

	@Override
	public FilmDTO addFilm(FilmDTO filmDTO) {
		 Film film = FilmDTO.toEntity(filmDTO);
	        Film filmSaved= repositoryFilm.save(film);
	        return FilmDTO.fromEntity(filmSaved);
	}
	 @Override
	    public FilmDTO findById(Long id) {
	        Optional<Film> optionalFilm =repositoryFilm.findById(id);
	        if (optionalFilm.isPresent()) {
	            Film film=optionalFilm.get();
	            return FilmDTO.fromEntity(film);
	        }
	        else {
	            return null;
	        }
	    }

	    @Override
	    public void deleteById(Long id) {
	    repositoryFilm.deleteById(id);
	    }

	    @Override
	    public List<FilmDTO> findAll() {
	        return repositoryFilm.findAll().stream().map(FilmDTO::fromEntity).collect(Collectors.toList());
	    }

	    
	    // Opération Update
	    public FilmDTO updateFilm(Long id, FilmDTO filmDTO) {
	        Optional<Film> existingFilm = repositoryFilm.findById(id);
	        if (existingFilm.isPresent()) {
	            Film updatedFilm = existingFilm.get();
	            updatedFilm.setCreateur(filmDTO.getCreateur());
	            updatedFilm.setDescription(filmDTO.getDescription());
	            updatedFilm.setDureeFilm(filmDTO.getDureeFilm());
	            updatedFilm.setNomFilm(filmDTO.getNomFilm());
	            updatedFilm.setCategory(filmDTO.getCategory());
	            updatedFilm.setImage(filmDTO.getImage());
	            //updatedFilm.isActif()()
	            // Mettre à jour d'autres propriétés de l'utilisateur si nécessaire
	            Film savedFilm = repositoryFilm.save(updatedFilm);

	            FilmDTO savedFilmDTO = new FilmDTO();
	            savedFilmDTO.setCreateur(savedFilm.getCreateur());
	            savedFilmDTO.setDescription(savedFilm.getDescription());
	            savedFilmDTO.setDureeFilm(savedFilm.getDureeFilm());
	            savedFilmDTO.setCategory(savedFilm.getCategory());
	            savedFilmDTO.setImage(savedFilm.getImage());
	            savedFilmDTO.setNomFilm(savedFilm.getNomFilm());

	            //updatedFilm.setIsactif(false);
	            // Copier d'autres propriétés de l'utilisateur si nécessaire

	            return savedFilmDTO;
	        }
	        return null; // Gérer le cas où l'utilisateur n'est pas trouvé
	    }

}

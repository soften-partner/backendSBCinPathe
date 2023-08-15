package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SalleDTO;
import com.example.demo.entity.Salle;
import com.example.demo.repository.SalleRepository;

@Service
public class SalleServiceImplementation implements IsalleSeervice{
	@Autowired
	private SalleRepository repository;
    @Override
    public SalleDTO addSalle(SalleDTO salleDTO) {
        Salle salle = SalleDTO.toEntity(salleDTO);
        Salle salleSaved= repository.save(salle);
        return SalleDTO.fromEntity(salleSaved);
    }

    @Override
    public SalleDTO findById(Long id) {
        Optional<Salle> optionalSalle =repository.findById(id);
        if (optionalSalle.isPresent()) {
            Salle salle=optionalSalle.get();
            return SalleDTO.fromEntity(salle);
        }
        else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
    repository.deleteById(id);
    }

    @Override
    public List<SalleDTO> findAll() {
        return repository.findAll().stream().map(SalleDTO::fromEntity).collect(Collectors.toList());
    }

    
    // Opération Update
    public SalleDTO updateSalle(Long id, SalleDTO salleDTO) {
        Optional<Salle> existingSalle = repository.findById(id);
        if (existingSalle.isPresent()) {
            Salle updatedSalle = existingSalle.get();
            updatedSalle.setNbrPlaces(salleDTO.getNbrPlaces());
            updatedSalle.setNomSalle(salleDTO.getNomSalle());
            // Mettre à jour d'autres propriétés de l'utilisateur si nécessaire
            Salle savedSalle = repository.save(updatedSalle);

            SalleDTO savedSalleDTO = new SalleDTO();
            savedSalleDTO.setIdSalle(savedSalle.getIdSalle());
            savedSalleDTO.setNbrPlaces(savedSalle.getNbrPlaces());
            savedSalleDTO.setNomSalle(savedSalle.getNomSalle());
            // Copier d'autres propriétés de l'utilisateur si nécessaire

            return savedSalleDTO;
        }
        return null; // Gérer le cas où l'utilisateur n'est pas trouvé
    }
}



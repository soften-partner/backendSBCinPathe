package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProjectionDTO;
import com.example.demo.dto.SalleDTO;
import com.example.demo.entity.Projection;
import com.example.demo.entity.Salle;
import com.example.demo.repository.ProjectionRepository;
import com.example.demo.repository.SalleRepository;
@Service
public class ProjectionServiceImplementation  implements IProjectionService{
	@Autowired
	private ProjectionRepository repository;
    @Override
    public ProjectionDTO addProjection(ProjectionDTO projectionDTO) {
        Projection projection = ProjectionDTO.toEntity(projectionDTO);
        Projection projectionSaved= repository.save(projection);
        return ProjectionDTO.fromEntity(projectionSaved);
    }

    @Override
    public ProjectionDTO findById(Long id) {
        Optional<Projection> optionalProjection=repository.findById(id);
        if (optionalProjection.isPresent()) {
            Projection projection=optionalProjection.get();
            return ProjectionDTO.fromEntity(projection);
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
    public List<ProjectionDTO> findAll() {
        return repository.findAll().stream().map(ProjectionDTO::fromEntity).collect(Collectors.toList());
    }

    
    // Opération Update
    public ProjectionDTO updateProjection(Long id, ProjectionDTO projectionDTO) {
        Optional<Projection> existingProjection = repository.findById(id);
        if (existingProjection.isPresent()) {
            Projection updatedProjection = existingProjection.get();
            updatedProjection.setDateProjection(projectionDTO.getDateProjection());
            updatedProjection.setTarifProjection(projectionDTO.getTarifProjection());
            // Mettre à jour d'autres propriétés de l'utilisateur si nécessaire
            Projection savedProjection = repository.save(updatedProjection);

            ProjectionDTO savedProjectionDTO = new ProjectionDTO();
            savedProjectionDTO.setDateProjection(savedProjection.getDateProjection());
            savedProjectionDTO.setTarifProjection(savedProjection.getTarifProjection());
            // Copier d'autres propriétés de l'utilisateur si nécessaire

            return savedProjectionDTO;
        }
        return null; // Gérer le cas où l'utilisateur n'est pas trouvé
    }
}
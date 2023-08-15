package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.FilmDTO;
import com.example.demo.dto.ProjectionDTO;

public interface IProjectionService {

	ProjectionDTO addProjection(ProjectionDTO filmDTO);
	ProjectionDTO findById (Long id);
    void deleteById (Long id);
    List<ProjectionDTO> findAll();
    ProjectionDTO updateProjection(Long id, ProjectionDTO projectionDTO);
}


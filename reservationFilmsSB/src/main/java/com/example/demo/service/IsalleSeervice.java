package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.SalleDTO;

public interface IsalleSeervice {

	SalleDTO addSalle(SalleDTO salleDTO);
	SalleDTO findById (Long id);
    void deleteById (Long id);
    List<SalleDTO> findAll();
    SalleDTO updateSalle(Long id, SalleDTO salleDTO);

}

package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.Pageable;

public interface IBuildingService {
	List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch,Pageable pageable);
	BuildingDTO findById(Long id);
	BuildingDTO insert(BuildingDTO buildingDTO);
	String delete(Long id);
	String delete(Long[] ids);
}

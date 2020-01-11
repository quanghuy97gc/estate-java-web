package com.laptrinhjavaweb.service.impl;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import com.laptrinhjavaweb.repository.impl.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService {

	private IBuildingRepository buildingRepository;
	private BuildingConverter buildingConverter;

	public BuildingService() {
		buildingRepository = new BuildingRepository();
		buildingConverter = new BuildingConverter();
	}
	
	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch, Pageable pageable) {
		// java 7
		/*
		 * List<BuildingDTO> buildingDTOs = new ArrayList<BuildingDTO>();
		 * List<BuildingEntity> buildingEntities = buildingRepository.findAll();
		 * for(BuildingEntity item:buildingEntities) {
		 * buildingDTOs.add(buildingConverter.convertToDTO(item)); }
		 */
		// java 8
		//BuildingConverter buildingConverter = new BuildingConverter();
		Map<String, Object> properties = convertToMapProperties(fieldSearch);
		return buildingRepository.findAll(properties, pageable, fieldSearch).stream()
				.map(item -> buildingConverter.convertToDTO(item)).collect(Collectors.toList());
	}

	@Override
	public BuildingDTO insert(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		buildingEntity.setCreatedBy("quanghuy");
		buildingEntity.setCreatedDate(new Date());
		Long id = buildingRepository.insert(buildingEntity);
		return buildingConverter.convertToDTO(buildingRepository.findById(id));
	}
	
	@Override
	public BuildingDTO findById(Long id) {
		return buildingConverter.convertToDTO(buildingRepository.findById(id));
	}

	private Map<String, Object> convertToMapProperties(BuildingSearchBuilder fieldSearch) {
		Map<String, Object> properties = new HashMap<String, Object>();
		Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				if (field.get(fieldSearch) != null && !field.getName().equals("buildingType")
						&& !field.getName().equals("staffId") && !field.getName().startsWith("costRent")
						&& !field.getName().startsWith("areaRent")) {
					if (StringUtils.isNotBlank(field.get(fieldSearch).toString())) {
						properties.put(field.getName(), field.get(fieldSearch));
					}
				}
			} catch (IllegalAccessException e) {
				System.out.println(e.getMessage());
			}
		}
		return properties;
	}



}

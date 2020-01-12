package com.laptrinhjavaweb.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;

public class BuildingConverter extends Converter<BuildingDTO, BuildingEntity>{
	@Override
	public BuildingEntity convertToEntity(BuildingDTO dto) {
		String[] buildingTypes = Arrays.stream(dto.getBuildingType()).filter(StringUtils::isNotBlank)
				.toArray(String[]::new);
		if(buildingTypes.length > 0) {
			dto.setType(String.join(",", buildingTypes));
		}
		return super.convertToEntity(dto);
	}

	public BuildingDTO convertToDTO(BuildingEntity entity,List<RentAreaEntity> rentAreaEntity) {
		BuildingDTO buildingDTO = super.convertToDTO(entity);
		String areaRent = rentAreaEntity.stream().map(item -> item.getValue().toString()).collect(Collectors.joining(","));
		buildingDTO.setAreaRent(areaRent);
		return buildingDTO;
	}
}

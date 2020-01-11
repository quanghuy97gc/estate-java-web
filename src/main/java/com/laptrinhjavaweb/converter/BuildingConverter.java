package com.laptrinhjavaweb.converter;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;

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
	
}

package com.laptrinhjavaweb.converter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.modelmapper.ModelMapper;

public class Converter<DTO,Entity>{
	
	private Class<DTO> dtoClass;
	private Class<Entity> entityClass;
	
	@SuppressWarnings("unchecked")
	public Converter() {
		Type type = getClass().getGenericSuperclass(); 
		ParameterizedType parameterizedType = (ParameterizedType) type;
		dtoClass = (Class<DTO>) parameterizedType.getActualTypeArguments()[0];
		entityClass = (Class<Entity>) parameterizedType.getActualTypeArguments()[1];
		
	}
	
	
	public static <D> D map(Object entity,Class<D> destinationType) {
		ModelMapper modelMapper = new ModelMapper();
		return (D) modelMapper.map(entity, destinationType);
	}
	
	public DTO convertToDTO(Entity entity) {
		if(entity == null) {
			return null;
		}
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(entity, dtoClass);
	} 
	public Entity convertToEntity(DTO dto) {
		if(dto == null) {
			return null;
		}
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, entityClass);
	} 
}

package com.laptrinhjavaweb.service.impl;

import java.util.Date;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.IUserRepository;
import com.laptrinhjavaweb.repository.impl.UserRepository;
import com.laptrinhjavaweb.service.IUserService;

public class UserService implements IUserService{

	private IUserRepository userRepository;
	private UserConverter userConverter;
	
	public UserService() {
		userRepository = new UserRepository();
		userConverter = new UserConverter();
	}
	
	@Override
	public UserDTO findById(Long id) {
		return userConverter.convertToDTO(userRepository.findById(id));
	}

	@Override
	public UserDTO insert(UserDTO userDTO) {
//		if(userDTO == null) {
//			return null;
//		}
		UserEntity userEntity = userConverter.convertToEntity(userDTO);
		userEntity.setCreatedBy("quanghuy");
		userEntity.setCreatedDate(new Date());
		Long id = userRepository.insert(userEntity);
		return userConverter.convertToDTO(userRepository.findById(id));
	}
	
}

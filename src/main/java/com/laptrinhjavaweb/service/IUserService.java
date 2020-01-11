package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.UserDTO;

public interface IUserService {
	public UserDTO findById(Long id);
	public UserDTO insert(UserDTO userDTO);
}

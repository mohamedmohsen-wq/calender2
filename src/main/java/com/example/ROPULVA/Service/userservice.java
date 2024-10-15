package com.example.ROPULVA.Service;

import org.springframework.stereotype.Service;

import com.example.ROPULVA.Model.DTO.UserDTO;
import com.example.ROPULVA.Model.Entity.userEntity;

@Service
public interface userservice {
	userEntity login(UserDTO userDTO);
}

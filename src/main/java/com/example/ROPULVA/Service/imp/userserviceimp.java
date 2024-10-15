package com.example.ROPULVA.Service.imp;

import org.springframework.stereotype.Service;

import com.example.ROPULVA.Model.DTO.UserDTO;
import com.example.ROPULVA.Model.Entity.userEntity;
import com.example.ROPULVA.Repository.UserRepository;
import com.example.ROPULVA.Service.userservice;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class userserviceimp  implements userservice{
	 private final UserRepository userRepository;
	    
	    
	    
	    public userEntity login(UserDTO userDTO) {
	    	userEntity user = userRepository.findByUsername(userDTO.getUsername());
	        if (user != null && user.getPassword().equals(userDTO.getPassword())) {
	            return user; 
	        }
	        return null; 
	    }

}

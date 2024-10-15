package com.example.ROPULVA.Model.Mapper;

import org.mapstruct.Mapper;

import com.example.ROPULVA.Model.DTO.UserDTO;
import com.example.ROPULVA.Model.Entity.userEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
	

    UserDTO toDTO(userEntity userEntity);
    userEntity toEntity(UserDTO userDTO);

}

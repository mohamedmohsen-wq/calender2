package com.example.ROPULVA.Model.DTO;

import java.time.LocalDateTime;

import com.example.ROPULVA.Model.Enum.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	 private String username;
	    private String password;
	  
}

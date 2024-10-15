package com.example.ROPULVA.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ROPULVA.Model.DTO.UserDTO;
import com.example.ROPULVA.Model.Entity.userEntity;
import com.example.ROPULVA.Service.userservice;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
	
private final userservice users;

@PostMapping("/login")
public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
    userEntity user = users.login(userDTO);
    if (user != null) {
        return ResponseEntity.ok("Login successful Welcome " + user.getName());
        
    }
    return ResponseEntity.status(401).body("Invalid username or password");
}

}

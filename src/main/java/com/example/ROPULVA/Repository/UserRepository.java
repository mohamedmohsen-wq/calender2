package com.example.ROPULVA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ROPULVA.Model.Entity.userEntity;

public interface UserRepository  extends JpaRepository<userEntity, Long>{
	userEntity findByUsername(String username);
}

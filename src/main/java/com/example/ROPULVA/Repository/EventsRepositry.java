package com.example.ROPULVA.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ROPULVA.Model.Entity.EventsEntity;

public interface EventsRepositry extends  JpaRepository<EventsEntity, Long> {
	  List<EventsEntity> findByUserUserId(Long userId);
}

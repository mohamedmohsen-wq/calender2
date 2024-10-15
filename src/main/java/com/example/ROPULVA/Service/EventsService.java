package com.example.ROPULVA.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ROPULVA.Model.DTO.EventsRespoDTO;
import com.example.ROPULVA.Model.DTO.EventsSendDTO;
import com.example.ROPULVA.Model.DTO.EventsupdateDTO;
import com.example.ROPULVA.Model.Entity.EventsEntity;

@Service
public interface EventsService {
	
	EventsRespoDTO  GetJobs(  Long id);
	
	EventsSendDTO send(EventsSendDTO entity);
	
	
	
	
	List<EventsRespoDTO> getJobsByUserId(Long userId);
	  EventsupdateDTO update(EventsupdateDTO entity);

	

	String delete(Long id);
	

}

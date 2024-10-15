package com.example.ROPULVA.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ROPULVA.Model.DTO.EventsRespoDTO;
import com.example.ROPULVA.Model.DTO.EventsSendDTO;
import com.example.ROPULVA.Model.DTO.EventsupdateDTO;
import com.example.ROPULVA.Model.Entity.EventsEntity;
import com.example.ROPULVA.Model.Mapper.EventsMapper;
import com.example.ROPULVA.Repository.EventsRepositry;
import com.example.ROPULVA.Service.EventsService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

//http://localhost:8089/api/Jobs

public class EventController {
	private final EventsService jopService;
	private final EventsRepositry joprepo;
	private final EventsMapper jopmapper;

	
	
	@GetMapping("/Jobs/{id}")
	public EventsRespoDTO GetTasks( @PathVariable(name = "id") Long id) {
		return this.jopService.GetJobs(id);
		}
	
	@PostMapping("/Jobs")
	
	
	public EventsSendDTO send( @RequestBody EventsSendDTO entity) {
		return this.jopService.send(entity);
		
		
	}
	
	@DeleteMapping("/Jobs/{id}")
	public String delete(@PathVariable Long id) {
	    return this.jopService.delete(id);
	}
	 
	
	
	@PutMapping("/Jobs")
	public EventsupdateDTO update(@RequestBody EventsupdateDTO entity) {
		return this.jopService.update(entity);
	}

	 @GetMapping("/user/{userId}") 
	    public List<EventsRespoDTO> getJobsByUser(@PathVariable Long userId) {
	        return this.jopService.getJobsByUserId(userId);
	    }
	}









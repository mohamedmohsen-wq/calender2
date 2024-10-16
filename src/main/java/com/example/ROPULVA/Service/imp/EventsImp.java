package com.example.ROPULVA.Service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.ROPULVA.Component.EventsComponent;
import com.example.ROPULVA.Model.DTO.EventsRespoDTO;
import com.example.ROPULVA.Model.DTO.EventsSendDTO;
import com.example.ROPULVA.Model.DTO.EventsupdateDTO;
import com.example.ROPULVA.Model.Entity.EventsEntity;
import com.example.ROPULVA.Model.Entity.userEntity;
import com.example.ROPULVA.Model.Mapper.EventsMapper;
import com.example.ROPULVA.Repository.EventsRepositry;
import com.example.ROPULVA.Repository.UserRepository;
import com.example.ROPULVA.Service.EventsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class EventsImp implements EventsService {
	private final EventsRepositry repo;
	private final EventsMapper map;
	private final UserRepository userrepo;
	private final EventsComponent eventsComponent;
	
    private static final Logger logger = LoggerFactory.getLogger(EventsImp.class); 

	@Override
	 @Cacheable(value = "jobs", key = "#id")
	public EventsRespoDTO GetJobs(Long id) {
		 eventsComponent.logEventAction("Get", id);
		EventsEntity get= this.repo.getById(id);
		EventsRespoDTO getall=this.map.dto(get);
		return getall;
	}
	@Override
	public EventsSendDTO send(EventsSendDTO entity) {
		try {
			 eventsComponent.validateEventData(entity.getTitle(), entity.getDescription());
			userEntity user = userrepo.findById(entity.getUserId())
			        .orElseThrow(() -> new RuntimeException("user not found"));
			    EventsEntity send = this.map.toEntitysend(entity);
			    send.setUser(user);
			    EventsEntity savedEntity = this.repo.save(send);
			    EventsSendDTO saveFinish = this.map.Send(savedEntity);
			    return saveFinish;
			
		} catch (Exception e) {
			  logger.error("Error while sending job: {}", e.getMessage(), e);
		        throw new RuntimeException("An error occurred while sending the task");		}
	}
	@Override
	public String delete(Long id) { 
	    try {
	    	 eventsComponent.logEventAction("DELETE", id);
	        Optional<EventsEntity> jobToDelete = this.repo.findById(id);
	        
	        if (jobToDelete.isPresent()) {
	            EventsEntity job = jobToDelete.get();
	            this.repo.deleteById(id);
	            return "Job deleted successfully";
	        } else {
	            return "Job not found";
	        }
	    } catch (Exception e) {
	        logger.error("Error while deleting job: {}", e.getMessage(), e);
	        throw new RuntimeException("An error occurred while deleting the task");
	    }
	}
	
	@Override
	public EventsupdateDTO update(EventsupdateDTO entity) {
		try {
			 eventsComponent.validateEventData(entity.getTitle(), entity.getDescription());
			userEntity user = userrepo.findById(entity.getUserId())
		            .orElseThrow(() -> new RuntimeException("User not found"));
			EventsEntity update=this.map.toEntityupdate(entity);
			update.setUser(user);
			EventsEntity update1=this.repo.save(update);
			EventsupdateDTO update2=this.map.update(update1);
				return update2;
		} catch (Exception e) {
			 logger.error("Error while updating job: {}", e.getMessage(), e);
		        throw new RuntimeException("An error occurred while updating the task");		}
	}
	@Override
	@Cacheable(value = "jobsByUser", key = "#userId")
	public List<EventsRespoDTO> getJobsByUserId(Long userId) {
		 try {
			 eventsComponent.logEventAction("Get", userId);
			  List<EventsEntity> jobs = this.repo.findByUserUserId(userId);
		        return jobs.stream()
		                .map(map::dto) 
		                .collect(Collectors.toList());
		} catch (Exception e) {
			 logger.error("Error while fetching jobs by user ID: {}", e.getMessage(), e);
		        throw new RuntimeException("An error occurred while fetching tasks");		}
	}
	

	
}

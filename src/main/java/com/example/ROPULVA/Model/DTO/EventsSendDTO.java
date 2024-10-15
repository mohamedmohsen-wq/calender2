package com.example.ROPULVA.Model.DTO;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.example.ROPULVA.Model.Enum.Status;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventsSendDTO {
	

	   
	 private String title;

	    private String description;

	    private LocalDateTime startTime;

	    private LocalDateTime endTime;

	    @Enumerated(EnumType.STRING)
	    private Status status = Status.PENDING;

	    private boolean synced;
	    private Long userId;


	

}

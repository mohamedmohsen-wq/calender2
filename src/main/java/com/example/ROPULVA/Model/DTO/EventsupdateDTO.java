package com.example.ROPULVA.Model.DTO;

import java.time.LocalDateTime;

import com.example.ROPULVA.Model.Enum.Status;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventsupdateDTO {
	     private Long id;
		 private String title;

		    private String description;

		    private LocalDateTime startTime;

		    private LocalDateTime endTime;

		    @Enumerated(EnumType.STRING)
		    private Status status = Status.PENDING;

		    private boolean synced;
		    private Long userId;

}

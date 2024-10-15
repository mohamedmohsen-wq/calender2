package com.example.ROPULVA.Model.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.ROPULVA.Model.Enum.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "Evens")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class EventsEntity {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;

	    private String title;

	    private String description;


	    private LocalDateTime startTime;

	    private LocalDateTime endTime;

	    @Enumerated(EnumType.STRING)
	    private Status status = Status.PENDING;

	    private boolean issynced;

	    @Column(name = "google_event_id")
	    private String googleEventId;

	    @CreationTimestamp
	    @Column(name = "created_at")
	    private LocalDateTime createdAt;

	    @UpdateTimestamp
	    @Column(name = "updated_at")
	    private LocalDateTime updatedAt;
	    
	    @ManyToOne(fetch = FetchType.LAZY)     
	    @JoinColumn(name = "user_id", nullable = false) 
	    private userEntity user;
}


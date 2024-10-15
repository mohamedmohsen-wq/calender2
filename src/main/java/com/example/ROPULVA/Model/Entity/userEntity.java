package com.example.ROPULVA.Model.Entity;

import java.time.LocalDateTime;
import java.util.List;

import com.example.ROPULVA.Model.Enum.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class userEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "user_Id")
	    private Long userId;
	 
	 private String name;
	 private String username;
	 private String password;
	
	 
	  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY) 
	    private List<EventsEntity> jobs;
	 
	

}

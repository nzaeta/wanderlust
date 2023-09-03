package com.nicoz.NZWanderlust.Models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserLevel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userLevelId;
	private String levelName;	
	private Integer numberOfTickets;
	private Double profit;
	@OneToOne(mappedBy = "userLevel", cascade = CascadeType.ALL)
	@JsonBackReference
	private User user;

}
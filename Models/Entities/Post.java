package com.nicoz.NZWanderlust.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nicoz.NZWanderlust.Entities.TicketTravelBuyer;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import jakarta.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postID;
	
	private Long sellerID;	
	private String title;	
	private String description;
	private String startDate;
	private String endDate;
	private String images;	
	private Double price;
	private Integer numberOfTickets;
	private String transport;	
	private String hotel;		
	private String food;
	private String turisticPlan;

	@OneToMany(mappedBy="post", fetch = FetchType.LAZY)
	@JsonIgnore
    private List<TicketTravelBuyer> ticketTravelBuyer; 
	
	public Post() {
	}
	
	
	
}
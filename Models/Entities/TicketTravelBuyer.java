package com.nicoz.NZWanderlust.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class TicketTravelBuyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketTravelBuyerId;
    
    @ManyToOne
    private Post post;
    @ManyToOne   
    private User user;
    private String price;
    private LocalDate startDate;
    private LocalDate endDate;


}

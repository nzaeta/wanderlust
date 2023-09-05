package com.nicoz.NZWanderlust.Services;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class TicketTravelBuyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketTravelBuyerId;
    @ManyToOne
    private Post post;
    @ManyToOne()
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User user;
    private Double price;
    private String startDate;
    private String endDate;


}
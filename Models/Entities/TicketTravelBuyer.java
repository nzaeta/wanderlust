package com.nicoz.NZWanderlust.Entities;
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
    private Long postId;
    @ManyToOne()
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User user;
    private String price;
    private LocalDate startDate;
    private LocalDate endDate;


}
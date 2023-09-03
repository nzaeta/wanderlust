package com.nicoz.NZWanderlust.Models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reputationScore")
    private ReputationScore reputationScore;

    private String address;
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userLevel")
    private UserLevel userLevel;

    @OneToMany(mappedBy = "user")
    private List<TicketTravelBuyer> ticketTravelBuyerList;



}

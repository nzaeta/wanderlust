package com.nicoz.NZWanderlust.Services;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ReputationScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reputationScoreId;
    private Long score;
    @OneToOne(mappedBy = "reputationScore", cascade = CascadeType.ALL)
    @JsonBackReference
    private User user;



}

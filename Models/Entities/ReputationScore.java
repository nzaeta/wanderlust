package com.nicoz.NZWanderlust.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReputationScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reputationScoreId;

    private Long userIdReputation;
    private Long score;
}

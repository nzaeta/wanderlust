package com.nicoz.NZWanderlust.Models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "reputationScoreId")*/
public class ReputationScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reputationScoreId;
    private Long score;
    @OneToOne(mappedBy = "reputationScore", cascade = CascadeType.ALL)
    @JsonBackReference
    private User user;



}

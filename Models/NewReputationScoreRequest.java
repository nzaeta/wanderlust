package com.woderlust.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewReputationScoreRequest {
    private Long userIdReputation;
    private Long score;
}

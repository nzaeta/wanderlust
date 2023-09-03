package com.nicoz.NZWanderlust;

import com.nicoz.NZWanderlust.Models.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class NewTicketTravelBuyerRequest {
    private Long postId;
    private User user;
    private String price;
    private LocalDate startDate;
    private LocalDate endDate;

}

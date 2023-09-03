package com.nicoz.NZWanderlust.controller;

import com.nicoz.NZWanderlust.Models.entities.TicketTravelBuyer;
import com.nicoz.NZWanderlust.Models.entities.User;
import com.nicoz.NZWanderlust.Models.services.TicketTravelBuyerService;
import com.nicoz.NZWanderlust.Models.services.UserService;
import com.nicoz.NZWanderlust.NewTicketTravelBuyerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class BuyTicketController {
    private final UserService userService;

    private final TicketTravelBuyerService ticketTravelBuyerService;


    public BuyTicketController(UserService userService, TicketTravelBuyerService ticketTravelBuyerService) {
        this.userService = userService;
        this.ticketTravelBuyerService = ticketTravelBuyerService;
    }

    @PutMapping("addBuyerToTicket/{userId}/{ticketId}/")
    public ResponseEntity<?> addBuyerToTicket(@PathVariable Long userId, @PathVariable Long ticketId){
        User user = userService.getUser(userId);
        TicketTravelBuyer ticket = ticketTravelBuyerService.getTicket(ticketId);
        ticket.setUser(user);
        ticketTravelBuyerService.updateOnlyTicketTravelBuyer(ticketId, ticket);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

   @GetMapping("getTicketsByBuyer/{userId}/")
    public ResponseEntity<?> getTicketsByBuyer(@PathVariable Long userId){
        User user = userService.getUser(userId); //?
        List<TicketTravelBuyer> ticketsByBuyer = user.getTicketTravelBuyerList();
        return new ResponseEntity<>(ticketsByBuyer , HttpStatus.OK);

    }

}

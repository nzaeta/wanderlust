package com.nicoz.NZWanderlust.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

@Entity
public class TicketTravelBuyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketTravelBuyerId;
    
    @ManyToOne
    private Post post;  
    private Long buyerId;
    private String price;
    private LocalDate startDate;
    private LocalDate endDate;

    public Long getTicketTravelBuyerId() {
        return ticketTravelBuyerId;
    }

    public void setTicketTravelBuyerId(Long ticketTravelBuyerId) {
        this.ticketTravelBuyerId = ticketTravelBuyerId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

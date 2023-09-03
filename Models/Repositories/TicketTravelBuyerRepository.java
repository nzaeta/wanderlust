package com.nicoz.NZWanderlust.Models.repository;

import com.nicoz.NZWanderlust.Models.entities.TicketTravelBuyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TicketTravelBuyerRepository extends JpaRepository<TicketTravelBuyer, Long> {

   /* @Query("FROM TicketTravelBuyer t WHERE t.user.userId  = ?1")
    List<TicketTravelBuyer> getAllTicketTravelBuyersById(Long id);
    */
}

package com.nicoz.NZWanderlust.Repositories;


import com.nicoz.NZWanderlust.Entities.TicketTravelBuyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketTravelBuyerRepository extends JpaRepository<TicketTravelBuyer, Long> {
}

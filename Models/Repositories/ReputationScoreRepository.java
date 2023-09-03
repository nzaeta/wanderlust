package com.nicoz.NZWanderlust.Models.repository;

import com.nicoz.NZWanderlust.Models.entities.ReputationScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReputationScoreRepository extends JpaRepository<ReputationScore, Long> {

}

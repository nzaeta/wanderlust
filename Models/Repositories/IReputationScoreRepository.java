package com.woderlust.repository;

import com.woderlust.entities.ReputationScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReputationScoreRepository extends JpaRepository<ReputationScore, Long> {

}

package com.nicoz.NZWanderlust.Repositories;
import com.nicoz.NZWanderlust.Entities.UserLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLevelRepository extends JpaRepository<UserLevel, Long>{
}

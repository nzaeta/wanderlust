package com.nicoz.NZWanderlust.Repositories;

import com.nicoz.NZWanderlust.Entities.DataPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDataPaymentRepository extends JpaRepository<DataPayment, Long> {
}

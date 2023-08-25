package com.woderlust.repository;

import com.woderlust.entities.DataPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDataPaymentRepository extends JpaRepository<DataPayment, Long> {
}

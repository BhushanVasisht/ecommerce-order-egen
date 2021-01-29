package com.egen.orderproc.repository;

import com.egen.orderproc.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

    @Query(value = "SELECT * FROM orders_payment WHERE order_id = ?1", nativeQuery = true)
    List<Payment> findPaymentsById(String order_id);
}

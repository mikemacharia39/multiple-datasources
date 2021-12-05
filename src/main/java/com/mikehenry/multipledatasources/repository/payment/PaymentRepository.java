package com.mikehenry.multipledatasources.repository.payment;

import com.mikehenry.multipledatasources.model.payment.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

    List<PaymentEntity> findAll();
}

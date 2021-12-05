package com.mikehenry.multipledatasources.service;

import com.mikehenry.multipledatasources.model.payment.PaymentEntity;
import com.mikehenry.multipledatasources.repository.payment.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public List<PaymentEntity> fetchAllPayments() {
        return paymentRepository.findAll();
    }
}

package com.mikehenry.multipledatasources.service;

import com.mikehenry.multipledatasources.model.payment.PaymentEntity;

import java.util.List;

public interface PaymentService {

    List<PaymentEntity> fetchAllPayments();
}

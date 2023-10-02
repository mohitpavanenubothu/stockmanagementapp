package com.payment.upi.service;

import com.payment.upi.model.PaymentRequest;
import com.payment.upi.model.PaymentResponse;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(String orderId);
}
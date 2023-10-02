package com.order.equitymarket.external.request;

import com.order.equitymarket.model.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    private long id;
    private long orderId;
    private long amount;
    private String referenceNumber;
    private PaymentMode paymentMode;

}

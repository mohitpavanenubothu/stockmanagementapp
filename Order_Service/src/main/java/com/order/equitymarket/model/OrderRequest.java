package com.order.equitymarket.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private long id;
    private long productId;
    private long totalAmount;
    private long quantity;
    //private PaymentMode paymentMode;
}

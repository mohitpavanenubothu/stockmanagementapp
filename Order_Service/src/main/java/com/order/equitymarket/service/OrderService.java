package com.order.equitymarket.service;

import com.order.equitymarket.model.OrderRequest;
import com.order.equitymarket.model.OrderResponse;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetails(long orderId);
}

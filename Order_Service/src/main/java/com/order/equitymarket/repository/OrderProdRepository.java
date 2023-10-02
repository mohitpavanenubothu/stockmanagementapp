package com.order.equitymarket.repository;

import com.order.equitymarket.entities.OrderProd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProdRepository extends JpaRepository<OrderProd, Long> {
}

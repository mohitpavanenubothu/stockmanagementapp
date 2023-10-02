package com.order.equitymarket;

import com.order.equitymarket.entities.Order;
import com.order.equitymarket.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableFeignClients
@EnableTransactionManagement
public class OrderServiceApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private OrderRepository orderRepository;

    @PostConstruct
    public void initOrdersTable() {
        orderRepository.saveAll(Stream.of(
                        new Order("ITC", "FMCG", "intraday", 442),
						new Order("INFY", "Information Technology", "Longterm", 1474),
                        new Order("HDFC BANK", "Financial Services", "Longterm", 1534),
                        new Order("RELIANCE", "Oil & Gas", "Longterm", 2340),
						new Order("RAINBOW", "Healthcare", "Longterm", 1047),
                        new Order("TCS", "Information Technology", "Longterm", 3572),
                        new Order("L&T", "Construction", "intraday", 2883),
                        new Order("ASIANPAINT", "Consumer Durables", "Longterm", 3312),
						new Order("MARUTI", "Automobile", "intraday", 10650),
						new Order("ICICI BANK", "Financial Services", "Longterm", 949),
						new Order("SUNPHARMA", "Healthcare", "Longterm", 1129),
						new Order("UPL", "Chemicals", "Longterm", 622),
						new Order("ULTRACEMCO", "Construction Materials", "Longterm", 8200),
						new Order("EXPLEO", "Information Technology", "Longterm", 1425),
						new Order("SBI", "Financial Services", "Longterm", 593),
						new Order("ADANIENT", "Metals & Mining", "intraday", 2438),
						new Order("APOLLOHOSP", "Healthcare", "Longterm", 5048),
						new Order("WIPRO", "Information Technology", "Longterm", 415),
						new Order("Airtel", "Telecommunication", "Longterm", 907)
                ).
                collect(Collectors.toList()));
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{category}")
    public List<Order> getOrdersByCategory(@PathVariable String category) {
        return orderRepository.findByCategory(category);
    }


    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}

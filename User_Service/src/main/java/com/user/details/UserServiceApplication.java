package com.user.details;

import com.user.details.model.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class UserServiceApplication {

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    public static final String USER_SERVICE = "userService";

    private static final String BASEURL = "http://localhost:8098/orders";

    private int attempt = 1;

    @GetMapping("/displayOrders")
    // @CircuitBreaker(name =USER_SERVICE,fallbackMethod = "getAllAvailableProducts")
    //@Retry(name = USER_SERVICE,fallbackMethod = "getAllAvailableProducts")
    public List<OrderDTO> displayOrders(@RequestParam("category") String category) {
        String url = category == null ? BASEURL : BASEURL + "/" + category;
        System.out.println("retry method called " + attempt++ + " times " + " at " + new Date());
        return restTemplate.getForObject(url, ArrayList.class);
    }

    public List<OrderDTO> getAllAvailableProducts(Exception e) {
        return Stream.of(
                new OrderDTO(12, "ITC", "FMCG", "intraday", 442),
                new OrderDTO(1, "INFY", "Information Technology", "Longterm", 1474),
                new OrderDTO(25, "HDFC BANK", "Financial Services", "Longterm", 1534),
                new OrderDTO(65, "RELIANCE", "Oil & Gas", "Longterm", 2340),
                new OrderDTO(9, "RAINBOW", "Healthcare", "Longterm", 1047),
                new OrderDTO(6, "TCS", "Information Technology", "Longterm", 3572),
                new OrderDTO(89, "L&T", "Construction", "intraday", 2883),
                new OrderDTO(72, "ASIANPAINT", "Consumer Durables", "Longterm", 3312),
                new OrderDTO(71, "MARUTI", "Automobile", "intraday", 10650),
                new OrderDTO(7, "ICICI BANK", "Financial Services", "Longterm", 949),
                new OrderDTO(4, "SUNPHARMA", "Healthcare", "Longterm", 1129),
                new OrderDTO(19, "UPL", "Chemicals", "Longterm", 622),
                new OrderDTO(28, "ULTRACEMCO", "Construction Materials", "Longterm", 8200),
                new OrderDTO(36, "EXPLEO", "Information Technology", "Longterm", 1425),
                new OrderDTO(45, "SBI", "Financial Services", "Longterm", 593),
                new OrderDTO(55, "ADANIENT", "Metals & Mining", "intraday", 2438),
                new OrderDTO(64, "APOLLOHOSP", "Healthcare", "Longterm", 5048),
                new OrderDTO(77, "WIPRO", "Information Technology", "Longterm", 415),
                new OrderDTO(88, "Airtel", "Telecommunication", "Longterm", 907)
        ).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

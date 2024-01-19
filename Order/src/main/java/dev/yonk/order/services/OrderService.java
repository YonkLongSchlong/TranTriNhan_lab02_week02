package dev.yonk.order.services;

import dev.yonk.order.dto.OrderResponse;
import dev.yonk.order.dto.ProductDto;
import dev.yonk.order.dto.UserDto;
import dev.yonk.order.models.Order;
import dev.yonk.order.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    public OrderResponse getOrderById(Long id){
        UserDto userDto = restTemplate.getForObject("http://localhost:8080/users/1", UserDto.class);
        ProductDto productDto = restTemplate.getForObject("http://localhost:8081/products/1", ProductDto.class);
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return new OrderResponse(order.getId(), userDto, productDto, order.getPrice(), order.getQuantity());
    }
}

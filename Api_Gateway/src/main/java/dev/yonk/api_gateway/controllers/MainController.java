package dev.yonk.api_gateway.controllers;

import dev.yonk.api_gateway.dto.OrderDto;
import dev.yonk.api_gateway.dto.ProductDto;
import dev.yonk.api_gateway.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
public class MainController {

    private final RestTemplate restTemplate;

    @Autowired
    public MainController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        OrderDto orderDto = restTemplate.getForObject("http://localhost:8082/orders/" + id, OrderDto.class);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        ProductDto productDto = restTemplate.getForObject("http://localhost:8081/products/" + id, ProductDto.class);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = restTemplate.getForObject("http://localhost:8080/users/" + id, UserDto.class);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}

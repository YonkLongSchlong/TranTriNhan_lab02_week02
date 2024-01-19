package dev.yonk.order;

import dev.yonk.order.models.Order;
import dev.yonk.order.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderApplication implements CommandLineRunner {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderApplication(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        Order order = new Order();
        order.setProductId(1L);
        order.setUserId(1L);
        order.setQuantity(2);
        order.setPrice(400);
        orderRepository.save(order);
    }
}

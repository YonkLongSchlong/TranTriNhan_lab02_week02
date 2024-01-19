package dev.yonk.product;

import dev.yonk.product.models.Product;
import dev.yonk.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApplication implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Autowired
    public ProductApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
    @Override
    public void run(String... args){
        Product product1 = new Product(
                1L,
                "You can't see me t-shirt",
                200
        );
        productRepository.save(product1);
    }
}

package com.example.full_code_quynv.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void findAllWithNameOnly() {
        this.productRepository.findAllByName("Iphone 6s").forEach((p) -> {
            log.info("Product name: {}", p.getName());
        });
    }
}
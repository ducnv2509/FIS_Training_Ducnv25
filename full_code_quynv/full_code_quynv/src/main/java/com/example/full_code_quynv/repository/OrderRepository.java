package com.example.full_code_quynv.repository;

import com.example.full_code_quynv.entity.Order;
import com.example.full_code_quynv.entity.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findAllByStatus(OrderStatus orderStatus, Pageable page);

    Page<Order> findAllByOrderDateTimeBetween(LocalDateTime fromDateTime, LocalDateTime toDateTime, Pageable page);
}

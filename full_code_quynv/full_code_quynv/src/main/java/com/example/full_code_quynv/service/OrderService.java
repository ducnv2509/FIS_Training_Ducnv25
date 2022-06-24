package com.example.full_code_quynv.service;

import com.example.full_code_quynv.dto.OrderDTO;
import com.example.full_code_quynv.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    Page<OrderDTO> findAll(Pageable pageable);
    Page<OrderDTO> findAllPaidOrders(Pageable pageable);
    Page<OrderDTO> findAllByDateTimeBetween(LocalDateTime fromDate, LocalDateTime toDate, Pageable pageable);

    OrderDTO findById(Long orderId);
}

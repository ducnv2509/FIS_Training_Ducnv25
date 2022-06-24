package com.example.full_code_quynv.service.impl;

import com.example.full_code_quynv.dto.OrderDTO;
import com.example.full_code_quynv.entity.OrderStatus;
import com.example.full_code_quynv.repository.OrderRepository;
import com.example.full_code_quynv.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    final
    OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Page<OrderDTO> findAll(Pageable pageable) {
        log.info("Query all Order... PageNumber: {}, PageSize: {}", pageable.getPageNumber(), pageable.getPageSize());
        return this.orderRepository.findAll(pageable).map(OrderDTO.Mapper::fromEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<OrderDTO> findAllPaidOrders(Pageable pageable) {
        return this.orderRepository.findAllByStatus(OrderStatus.PAID, pageable).map(OrderDTO.Mapper::fromEntity);
    }

    @Override
    public Page<OrderDTO> findAllByDateTimeBetween(LocalDateTime fromDateTime, LocalDateTime toDateTime, Pageable pageable) {
        return this.orderRepository.findAllByOrderDateTimeBetween(fromDateTime, toDateTime, pageable).map(OrderDTO.Mapper::fromEntity);
    }

    @Override
    public OrderDTO findById(Long orderId) {
        return OrderDTO.Mapper.fromEntity(
                this.orderRepository.findById(orderId).orElseThrow(() -> {
                    throw new IllegalArgumentException(String.format("Not found order id %s", orderId));
                })
        );

    }
}

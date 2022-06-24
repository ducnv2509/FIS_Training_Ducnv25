package com.example.full_code_quynv.dto;

import com.example.full_code_quynv.entity.Customer;
import com.example.full_code_quynv.entity.Order;
import com.example.full_code_quynv.entity.OrderItem;
import com.example.full_code_quynv.entity.OrderStatus;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderDTO {
    private Long id;
    private LocalDateTime orderDateTime;
    private Long customerID;
    private List<OrderItem> orderItems;
    private Double totalAmount;
    private OrderStatus status;

    public static class Mapper {
        public static OrderDTO fromEntity(Order order) {
            return OrderDTO.builder().id(order.getId())
                    .orderDateTime(order.getOrderDateTime())
                    .orderItems(order.getOrderItems())
                    .customerID(order.getCustomer().getId())
                    .totalAmount(order.getTotalAmount())
                    .status(order.getStatus())
                    .build();
        }
    }
}

package vn.fis.training.ordermanagement.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.domain.OrderStatus;
import vn.fis.training.ordermanagement.service.OrderItemService;
import vn.fis.training.ordermanagement.service.OrderService;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemService orderItemService;

    @org.junit.jupiter.api.Test
    void createOrder() {

    }

    @org.junit.jupiter.api.Test
    void addOrderItem() {

    }

    @org.junit.jupiter.api.Test
    void removeOrderItem() {
    }

    @org.junit.jupiter.api.Test
    void updateOrderStatus() {
        orderService.updateOrderStatus(OrderStatus.valueOf("CREATED"), 1L);
    }

    @org.junit.jupiter.api.Test
    void findOrdersBetween() {
        int size = orderService.findOrdersBetween(LocalDateTime.of(2022, Month.JUNE, 3, 21, 8, 6), LocalDateTime.of(2022, Month.JUNE, 10, 21, 6, 55)).size();
        System.out.println(size);
    }

    @org.junit.jupiter.api.Test
    void findWaitingApprovalOrders() {
        System.out.println(orderService.findWaitingApprovalOrders(OrderStatus.valueOf("WAITING_APPROVAL")).size());
    }

    @org.junit.jupiter.api.Test
    void findOrdersByOrderStatus() {
        assertEquals(1, orderService.findOrdersByOrderStatus(OrderStatus.valueOf("CREATED")).size());
    }

    @org.junit.jupiter.api.Test
    void findOrdersByCustomer() {
        Customer customer = new Customer();
        customer.setId(2L);
        System.out.println(orderService.findOrdersByCustomer(customer));
    }
}
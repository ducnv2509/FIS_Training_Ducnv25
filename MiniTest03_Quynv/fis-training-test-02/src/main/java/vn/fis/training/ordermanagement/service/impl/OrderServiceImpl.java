package vn.fis.training.ordermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.domain.Order;
import vn.fis.training.ordermanagement.domain.OrderItem;
import vn.fis.training.ordermanagement.domain.OrderStatus;
import vn.fis.training.ordermanagement.repository.OrderItemRepository;
import vn.fis.training.ordermanagement.repository.OrderRepository;
import vn.fis.training.ordermanagement.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public Order createOrder(Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public Order addOrderItem(Long orderID, OrderItem orderItem) {
        OrderItem item = orderItemRepository.save(orderItem);
        if (!orderID.equals(orderItem.getOrder().getId())) {
            throw new RuntimeException("id not match");
        }
        Order order = orderRepository.findById(item.getOrder().getId()).orElseThrow(() -> new RuntimeException("not find order"));
        order.setTotalAmount(order.getTotalAmount() + orderItem.getAmount() * orderItem.getProduct().getPrice());
        this.orderItemRepository.save(orderItem);
        return orderRepository.save(order);
    }

    @Override
    public Order removeOrderItem(Long orderID, OrderItem orderItem) {
        OrderItem item = orderItemRepository.save(orderItem);
        if (!orderID.equals(orderItem.getOrder().getId())) {
            throw new RuntimeException("id not match");
        }
        Order order = orderRepository.findById(item.getOrder().getId()).orElseThrow(() -> new RuntimeException("not find order"));
        order.setTotalAmount(order.getTotalAmount() + orderItem.getAmount() * orderItem.getProduct().getPrice());
        this.orderItemRepository.delete(orderItem);
        return orderRepository.save(order);
    }

    @Override
    public void updateOrderStatus( OrderStatus orderStatus, Long orderId) {
         this.orderRepository.updateOrderStatus(orderStatus, orderId);
    }

    @Override
    public List<Order> findOrdersBetween(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        return this.orderRepository.findByOrderDateTimeBetween(fromDateTime, toDateTime);
    }

    @Override
    public List<Order> findWaitingApprovalOrders(OrderStatus orderStatus) {
        return this.orderRepository.findOrderByStatus(orderStatus);
    }

    @Override
    public List<Order> findOrdersByOrderStatus(OrderStatus orderStatus) {
        return this.orderRepository.findOrderByStatus(orderStatus);
    }

    @Override
    public List<Order> findOrdersByCustomer(Customer customer) {
        return this.orderRepository.findOrderByCustomer(customer);
    }
}

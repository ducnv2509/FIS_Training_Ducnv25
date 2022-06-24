package vn.fis.training.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.domain.Order;
import vn.fis.training.ordermanagement.domain.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderDateTimeBetween(LocalDateTime fromDateTime, LocalDateTime toDateTime);
//    List<Order> findOrderByStatusMatches(OrderStatus orderStatus);
    List<Order> findOrderByStatus(OrderStatus orderStatus);
    List<Order> findOrderByCustomer(Customer customer);


    @Transactional
    @Modifying
    @Query("update Order o set o.status = ?1 where o.id = ?2")
    void updateOrderStatus(OrderStatus orderStatus, Long orderId);

}

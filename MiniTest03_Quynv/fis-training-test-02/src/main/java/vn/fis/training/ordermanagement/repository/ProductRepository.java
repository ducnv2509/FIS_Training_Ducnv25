package vn.fis.training.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.fis.training.ordermanagement.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

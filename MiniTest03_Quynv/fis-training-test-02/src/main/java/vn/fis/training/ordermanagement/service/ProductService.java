package vn.fis.training.ordermanagement.service;

import vn.fis.training.ordermanagement.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product addProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Long id);

    List<Product> getProducts();

    Optional<Product> getProduct(Long id);
}

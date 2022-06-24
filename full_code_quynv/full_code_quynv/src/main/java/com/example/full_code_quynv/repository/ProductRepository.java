package com.example.full_code_quynv.repository;

import com.example.full_code_quynv.dto.ProductDTO;
import com.example.full_code_quynv.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("Select p from Product p")
    List<ProductDTO> findAllWithNameOnly();

    List<ProductDTO> findAllByName(String name);

}

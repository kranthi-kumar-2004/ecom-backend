package com.kranthi.loginpage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kranthi.loginpage.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

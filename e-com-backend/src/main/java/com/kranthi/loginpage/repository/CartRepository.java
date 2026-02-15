package com.kranthi.loginpage.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kranthi.loginpage.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUser_Id(Integer userId);

    Cart findByUser_IdAndProduct_Id(Integer userId, Long productId);
}

package com.kranthi.loginpage.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kranthi.loginpage.dto.CartResponse;
import com.kranthi.loginpage.entity.Cart;
import com.kranthi.loginpage.repository.CartRepository;
import com.kranthi.loginpage.repository.ProductRepository;
import com.kranthi.loginpage.repository.UserRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductRepository productRepo;

    public void addToCart(Integer userId, Long productId) {

        Cart cart = cartRepo.findByUser_IdAndProduct_Id(userId, productId);

        if (cart == null) {
            cart = new Cart();
            cart.setUser(userRepo.findById(userId).get());
            cart.setProduct(productRepo.findById(productId).get());
            cart.setQuantity(1);
        } else {
            cart.setQuantity(cart.getQuantity() + 1);
        }

        cartRepo.save(cart);
    }

    

    public void removeFromCart(Integer userId, Long productId) {

        Cart cart = cartRepo.findByUser_IdAndProduct_Id(userId, productId);

        if (cart != null) {
            if (cart.getQuantity() > 1) {
                cart.setQuantity(cart.getQuantity() - 1);
                cartRepo.save(cart);
            } else {
                cartRepo.delete(cart);
            }
        }
    }
    public List<CartResponse> getCartByUser(Integer userId) {

    return cartRepo.findByUser_Id(userId)
        .stream()
        .map(c -> new CartResponse(
            c.getProduct().getId(),
            c.getQuantity()
        ))
        .collect(Collectors.toList());
}
}


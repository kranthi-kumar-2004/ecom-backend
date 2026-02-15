package com.kranthi.loginpage.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kranthi.loginpage.dto.CartResponse;

import com.kranthi.loginpage.service.CartService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public void addToCart(@RequestParam Integer userId,
                          @RequestParam Long productId) {
        cartService.addToCart(userId, productId);
    }

    @PostMapping("/remove")
    public void removeFromCart(@RequestParam Integer userId,
                               @RequestParam Long productId) {
        cartService.removeFromCart(userId, productId);
    }
    @GetMapping("/{userId}")
public List<CartResponse> getCartByUser(@PathVariable Integer userId) {
    return cartService.getCartByUser(userId);
}
}

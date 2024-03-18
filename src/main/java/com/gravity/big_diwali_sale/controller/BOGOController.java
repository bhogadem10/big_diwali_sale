package com.gravity.big_diwali_sale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gravity.big_diwali_sale.entity.Product;
import com.gravity.big_diwali_sale.service.BOGOService;

@RestController
@RequestMapping("/bogo")
public class BOGOController {
	@Autowired
    private BOGOService bogoService;

    @GetMapping("/offer1")
    public ResponseEntity<List<Product>> offerRule1(@RequestBody List<Product> products) {
        List<Product> discountedItems = bogoService.applyBOGOOfferRule1(products);
        return ResponseEntity.ok(discountedItems);
    }

    // Define endpoints for other offer rules
}

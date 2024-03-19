package com.gravity.big_diwali_sale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gravity.big_diwali_sale.entity.DiscountResponse;
import com.gravity.big_diwali_sale.service.ProductService;

@RestController
@RequestMapping("/bogo")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public String hello() {
		return "Hello!!!!";
	}

	@PostMapping("/products/discount-rule1")
    public DiscountResponse applyOfferRule1(@RequestBody List<Double> productPrices) {
        List<Double> discountedItems = productService.applyOfferRule1(productPrices);
        List<Double> payableItems = productPrices.stream().filter(price -> !discountedItems.contains(price)).toList();
        return new DiscountResponse(discountedItems, payableItems);
    }

    @PostMapping("/products/discount-rule2")
    public DiscountResponse applyOfferRule2(@RequestBody List<Double> productPrices) {
        List<Double> discountedItems = productService.applyOfferRule2(productPrices);
        List<Double> payableItems = productPrices.stream().filter(price -> !discountedItems.contains(price)).toList();
        return new DiscountResponse(discountedItems, payableItems);
    }

    @PostMapping("/products/discount-rule3")
    public DiscountResponse applyOfferRule3(@RequestBody List<Double> productPrices) {
        List<Double> discountedItems = productService.applyOfferRule3(productPrices);
        List<Double> payableItems = productPrices.stream().filter(price -> !discountedItems.contains(price)).toList();
        return new DiscountResponse(discountedItems, payableItems);
    }
}

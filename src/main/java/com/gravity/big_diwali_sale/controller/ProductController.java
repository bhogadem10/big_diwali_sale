package com.gravity.big_diwali_sale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gravity.big_diwali_sale.service.ProductService;

@RestController
//@RequestMapping("/products/offers")
public class ProductController {
	   @Autowired
	    private ProductService productService;

	    @PostMapping("/maximizeDiscount")
	    public List<List<Double>> maximizeDiscount(@RequestBody List<Double> productPrices, @RequestParam("rule") int rule) {
	        return productService.maximizeDiscount(productPrices, rule);
	    }
}

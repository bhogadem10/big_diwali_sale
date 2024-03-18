package com.gravity.big_diwali_sale.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gravity.big_diwali_sale.entity.Product;

@Service
public class BOGOService {
	// Offer Rule 1: Customers can buy one product and get another 
	//product for free as long as the price of the product is equal 
	//to or less than the price of the first product.

	public List<Product> applyBOGOOfferRule1(List<Product> productPrices) {
		Collections.sort(productPrices, Collections.reverseOrder());
		List<Integer> discountedItems = new ArrayList<>();
		List<Integer> payableItems = new ArrayList<>();

		for (int i = 0; i < productPrices.size(); i += 2) {
			discountedItems.add(productPrices.get(i));
			if (i + 1 < productPrices.size()) {
				payableItems.add(productPrices.get(i + 1));
			}
		}

		return List.of(discountedItems, payableItems);
	}

	// Offer Rule 2: Customers can buy one product and get another product for free as long as the 
	//price of the product is less than the price of the corresponding product in pairs.

	public List<Product> applyBOGOOfferRule2(List<Product> productPrices) {
		Collections.sort(productPrices, Collections.reverseOrder());
		List<Integer> discountedItems = new ArrayList<>();
		List<Integer> payableItems = new ArrayList<>();

		for (int i = 0; i < productPrices.size(); i += 2) {
			discountedItems.add(productPrices.get(i));
			if (i + 1 < productPrices.size()) {
				payableItems.add(productPrices.get(i + 1));
			}
		}

		return List.of(discountedItems, payableItems);
	}

	
	  // Offer Rule 3: Customers can buy two products and get two products for free as long as the price 
	//of the product is less than the price of the first product.
	   
	public List<Product> applyBOGOOfferRule3(List<Product> productPrices) {
		 Collections.sort(productPrices, Collections.reverseOrder());
	        List<Integer> discountedItems = new ArrayList<>();
	        List<Integer> payableItems = new ArrayList<>();

	        for (int i = 0; i < productPrices.size(); i += 4) {
	            discountedItems.add(productPrices.get(i));
	            if (i + 1 < productPrices.size()) {
	                discountedItems.add(productPrices.get(i + 1));
	            }
	            if (i + 2 < productPrices.size()) {
	                payableItems.add(productPrices.get(i + 2));
	            }
	            if (i + 3 < productPrices.size()) {
	                payableItems.add(productPrices.get(i + 3));
	            }
	        }

	        return List.of(discountedItems, payableItems);
	}
}

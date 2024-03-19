package com.gravity.big_diwali_sale.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gravity.big_diwali_sale.repository.ProductRepository;
@Service
public class ProductService {
	 @Autowired
	    private ProductRepository productRepository;

	    public List<List<Double>> maximizeDiscount(List<Double> productPrices, int rule) {
	        List<Double> discountedItems = new ArrayList<>();
	        List<Double> payableItems = new ArrayList<>();

	        // Sorting the product prices in descending order
	        Collections.sort(productPrices, Collections.reverseOrder());

	        switch (rule) {
	            case 1:
	                applyOfferRule1(productPrices, discountedItems, payableItems);
	                break;
	            case 2:
	                applyOfferRule2(productPrices, discountedItems, payableItems);
	                break;
	            case 3:
	                applyOfferRule3(productPrices, discountedItems, payableItems);
	                break;
	            default:
	                // Handle invalid rule number
	                break;
	        }

	        return List.of(discountedItems, payableItems);
	    }

	    private void applyOfferRule1(List<Double> productPrices, List<Double> discountedItems, List<Double> payableItems) {
	        if (productPrices.size() >= 2) {
	            discountedItems.add(productPrices.get(0)); // Add the highest priced item as discounted
	            discountedItems.add(productPrices.get(1)); // Add the second highest priced item as discounted
	            payableItems.addAll(productPrices.subList(2, productPrices.size())); // Add the rest as payable items
	        }
	    }

	    private void applyOfferRule2(List<Double> productPrices, List<Double> discountedItems, List<Double> payableItems) {
	        for (int i = 0; i < productPrices.size(); i++) {
	            double currentPrice = productPrices.get(i);
	            boolean isDiscounted = false;
	            for (int j = i + 1; j < productPrices.size(); j++) {
	                if (productPrices.get(j) <= currentPrice) {
	                    discountedItems.add(currentPrice);
	                    discountedItems.add(productPrices.get(j));
	                    isDiscounted = true;
	                    break;
	                }
	            }
	            if (!isDiscounted) {
	                payableItems.add(currentPrice);
	            }
	        }
	    }

	    private void applyOfferRule3(List<Double> productPrices, List<Double> discountedItems, List<Double> payableItems) {
	        if (productPrices.size() >= 4) {
	            discountedItems.add(productPrices.get(0)); // Add the highest priced item as discounted
	            discountedItems.add(productPrices.get(1)); // Add the second highest priced item as discounted
	            discountedItems.add(productPrices.get(2)); // Add the third highest priced item as discounted
	            discountedItems.add(productPrices.get(3)); // Add the fourth highest priced item as discounted
	            payableItems.addAll(productPrices.subList(4, productPrices.size())); // Add the rest as payable items
	        }
	    }
}

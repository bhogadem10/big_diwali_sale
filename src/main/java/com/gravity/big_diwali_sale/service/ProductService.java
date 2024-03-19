package com.gravity.big_diwali_sale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gravity.big_diwali_sale.entity.DiscountResponse;
@Service
public class ProductService {
	//@Autowired
	//private ProductRepository productRepository;

	 public DiscountResponse applyOfferRule1(List<Double> productPrices) {
	        List<Double> discountedItems = new ArrayList<>();
	        List<Double> payableItems = new ArrayList<>();
	        
	        // Sort the product prices in descending order
	        productPrices.sort((a, b) -> Double.compare(b, a));

	        // Iterate through the product prices to find pairs for discount
	        for (int i = 0; i < productPrices.size(); i++) {
	            if (i + 1 < productPrices.size()) {
	                // Check if the next item's price is less than or equal to the current item's price
	                if (productPrices.get(i + 1) <= productPrices.get(i)) {
	                    discountedItems.add(productPrices.get(i));
	                    discountedItems.add(productPrices.get(i + 1));
	                    i++; // Skip the next item since it's already paired
	                } else {
	                    // If the next item's price is greater, add the current item to payable items
	                    payableItems.add(productPrices.get(i));
	                }
	            } else {
	                // If it's the last item and it's unpaired, add it to payable items
	                payableItems.add(productPrices.get(i));
	            }
	        }

	        return new DiscountResponse(discountedItems, payableItems);
	    }

	 public DiscountResponse applyOfferRule2(List<Double> productPrices) {
	        // Sort the prices in descending order
	        List<Double> sortedPrices = productPrices.stream().sorted((a, b) -> Double.compare(b, a)).collect(Collectors.toList());

	        // Find pairs with maximum discount
	        List<Double> discountedItems = new ArrayList<>();
	        List<Double> payableItems = new ArrayList<>();
	        boolean[] paired = new boolean[sortedPrices.size()];

	        for (int i = 0; i < sortedPrices.size(); i++) {
	            if (!paired[i]) {
	                discountedItems.add(sortedPrices.get(i)); // Add the first item to discounted items
	                paired[i] = true; // Mark the item as paired

	                // Find a pair for the current item
	                for (int j = i + 1; j < sortedPrices.size(); j++) {
	                    if (!paired[j] && sortedPrices.get(j) < sortedPrices.get(i)) {
	                        discountedItems.add(sortedPrices.get(j)); // Add the pair to discounted items
	                        paired[j] = true; // Mark the pair as paired
	                        break; // Exit inner loop
	                    }
	                }
	            }
	        }

	        // Add unpaired items to payable items
	        for (int i = 0; i < sortedPrices.size(); i++) {
	            if (!paired[i]) {
	                payableItems.add(sortedPrices.get(i));
	            }
	        }

	        return new DiscountResponse(discountedItems, payableItems);
	    }

	 public DiscountResponse applyOfferRule3(List<Double> productPrices) {
	        // Sort the prices in descending order
	        List<Double> sortedPrices = productPrices.stream().sorted((a, b) -> Double.compare(b, a)).collect(Collectors.toList());

	        // Find pairs with maximum discount
	        List<Double> discountedItems = new ArrayList<>();
	        List<Double> payableItems = new ArrayList<>();

	        // Iterate through sorted prices, pairing two items for each iteration
	        for (int i = 0; i < sortedPrices.size(); i += 2) {
	            if (i + 1 < sortedPrices.size()) {
	                // Check if the second item's price is less than the first item's price
	                if (sortedPrices.get(i + 1) < sortedPrices.get(i)) {
	                    // Add the pair to discounted items
	                    discountedItems.add(sortedPrices.get(i));
	                    discountedItems.add(sortedPrices.get(i + 1));
	                } else {
	                    // Add the first item to payable items
	                    payableItems.add(sortedPrices.get(i));
	                    // Check if there's an unpaired item left
	                    if (i + 2 >= sortedPrices.size()) {
	                        // Add the last unpaired item to payable items
	                        payableItems.add(sortedPrices.get(i + 1));
	                    }
	                }
	            } else {
	                // Add the last unpaired item to payable items
	                payableItems.add(sortedPrices.get(i));
	            }
	        }

	        return new DiscountResponse(discountedItems, payableItems);
	    }
}

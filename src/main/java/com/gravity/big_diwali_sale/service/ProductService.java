package com.gravity.big_diwali_sale.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gravity.big_diwali_sale.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

    public List<Double> applyOfferRule1(List<Double> productPrices) {
        // Sort the prices in descending order
        List<Double> sortedPrices = productPrices.stream().sorted((a, b) -> Double.compare(b, a)).collect(Collectors.toList());

        // Find pairs with maximum discount
        List<Double> discountedItems = new ArrayList<>();
        List<Double> payableItems = new ArrayList<>();

        for (int i = 0; i < sortedPrices.size(); i += 2) {
            discountedItems.add(sortedPrices.get(i)); // Add higher-priced item to discounted items
            if (i + 1 < sortedPrices.size()) {
                payableItems.add(sortedPrices.get(i + 1)); // Add lower-priced item to payable items
            }
        }

        return discountedItems;
    }

    public List<Double> applyOfferRule2(List<Double> productPrices) {
        // Sort the prices in ascending order
        List<Double> sortedPrices = productPrices.stream().sorted().collect(Collectors.toList());

        // Find pairs with maximum discount
        List<Double> discountedItems = new ArrayList<>();
        List<Double> payableItems = new ArrayList<>();

        // Flag to indicate if the current item has been paired
        boolean[] paired = new boolean[sortedPrices.size()];

        for (int i = 0; i < sortedPrices.size(); i++) {
            if (!paired[i]) {
                // Find a pair for the current item
                for (int j = i + 1; j < sortedPrices.size(); j++) {
                    if (!paired[j] && sortedPrices.get(j) < sortedPrices.get(i)) {
                        discountedItems.add(sortedPrices.get(i)); // Add the pair to discounted items
                        discountedItems.add(sortedPrices.get(j));
                        paired[j] = true; // Mark the pair as paired
                        break; // Exit inner loop
                    }
                }
                // If no pair found, add the item to payable items
                if (!paired[i]) {
                    payableItems.add(sortedPrices.get(i));
                }
            }
        }

        return discountedItems;
    }

    public List<Double> applyOfferRule3(List<Double> productPrices) {
        // Sort the prices in descending order
        List<Double> sortedPrices = productPrices.stream().sorted((a, b) -> Double.compare(b, a)).collect(Collectors.toList());

        // Find pairs with maximum discount
        List<Double> discountedItems = new ArrayList<>();
        List<Double> payableItems = new ArrayList<>();

        // Iterate through the sorted prices
        for (int i = 0; i < sortedPrices.size(); i++) {
            if (i % 2 == 0) {
                // Add the first two items to discounted items
                discountedItems.add(sortedPrices.get(i));
                if (i + 1 < sortedPrices.size()) {
                    discountedItems.add(sortedPrices.get(i + 1));
                }
            } else {
                // Add the remaining items to payable items
                payableItems.add(sortedPrices.get(i));
            }
        }

        return discountedItems;
    }
}

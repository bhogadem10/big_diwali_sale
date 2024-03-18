package com.gravity.big_diwali_sale;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BigDiwaliSaleApplication {
	// Test cases
	public static void main(String[] args) {
		SpringApplication.run(BigDiwaliSaleApplication.class, args);
		
		List<Integer> productPrices = List.of(10, 20, 30, 40, 50, 60);
        System.out.println("Example 1 - Offer Rule 1:");
        System.out.println("Input: " + productPrices);
        List<List<Integer>> result1 = applyBOGOOfferRule1(new ArrayList<>(productPrices));
        System.out.println("Discounted Items: " + result1.get(0));
        System.out.println("Payable Items: " + result1.get(1));

        productPrices = List.of(10, 20, 30, 40, 50, 50, 60);
        System.out.println("\nExample 2 - Offer Rule 1:");
        System.out.println("Input: " + productPrices);
        List<List<Integer>> result2 = applyBOGOOfferRule1(new ArrayList<>(productPrices));
        System.out.println("Discounted Items: " + result2.get(0));
        System.out.println("Payable Items: " + result2.get(1));

        productPrices = List.of(10, 20, 30, 40, 40, 50, 60, 60);
        System.out.println("\nExample 1 - Offer Rule 2:");
        System.out.println("Input: " + productPrices);
        List<List<Integer>> result3 = applyBOGOOfferRule2(new ArrayList<>(productPrices));
        System.out.println("Discounted Items: " + result3.get(0));
        System.out.println("Payable Items: " + result3.get(1));

        productPrices = List.of(10, 20, 30, 40, 50, 50, 50, 60);
        System.out.println("\nExample 2 - Offer Rule 2:");
        System.out.println("Input: " + productPrices);
        List<List<Integer>> result4 = applyBOGOOfferRule2(new ArrayList<>(productPrices));
        System.out.println("Discounted Items: " + result4.get(0));
        System.out.println("Payable Items: " + result4.get(1));

        productPrices = List.of(10, 20, 30, 40, 40, 50, 60, 60);
        System.out.println("\nExample 1 - Offer Rule 3:");
        System.out.println("Input: " + productPrices);
        List<List<Integer>> result5 = applyBOGOOfferRule3(new ArrayList<>(productPrices));
        System.out.println("Discounted Items: " + result5.get(0));
        System.out.println("Payable Items: " + result5.get(1));

        productPrices = List.of(5, 5, 10, 20, 30, 40, 50, 50, 50, 60);
        System.out.println("\nExample 2 - Offer Rule 3:");
        System.out.println("Input: " + productPrices);
        List<List<Integer>> result6 = applyBOGOOfferRule3(new ArrayList<>(productPrices));
        System.out.println("Discounted Items: " + result6.get(0));
        System.out.println("Payable Items: " + result6.get(1));
	}
}

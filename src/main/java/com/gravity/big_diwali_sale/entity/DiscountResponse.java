package com.gravity.big_diwali_sale.entity;

import java.util.List;

public class DiscountResponse {
	private List<Double> discountedItems;
    private List<Double> payableItems;

    public DiscountResponse(List<Double> discountedItems, List<Double> payableItems) {
        this.discountedItems = discountedItems;
        this.payableItems = payableItems;
    }

    public List<Double> getDiscountedItems() {
        return discountedItems;
    }

    public void setDiscountedItems(List<Double> discountedItems) {
        this.discountedItems = discountedItems;
    }

    public List<Double> getPayableItems() {
        return payableItems;
    }

    public void setPayableItems(List<Double> payableItems) {
        this.payableItems = payableItems;
    }
}

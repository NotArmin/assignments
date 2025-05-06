package se.kth.IV1350.pos.integration;

import java.util.Map;

public class Discounts {
    private static final Map<Integer, Double> ITEM_DISCOUNTS = Map.of(
        1001, 0.05,
        1002, 0.05
    );
    
    private static final Map<Integer, Double> CUSTOMER_DISCOUNTS = Map.of(
        555, 0.05,
        777, 0.10
    );

    public static double getItemDiscountRate(int itemID) {
        return ITEM_DISCOUNTS.getOrDefault(itemID, 0.0);
    }

    public static double getSaleDiscount(double totalPrice) {
        return totalPrice > 100.0 ? 5.0 : 0.0;
    }

    public static double getCustomerDiscountRate(int customerID) {
        return CUSTOMER_DISCOUNTS.getOrDefault(customerID, 0.0);
    }
}
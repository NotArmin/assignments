package se.kth.IV1350.pos.model;

import java.util.ArrayList;
import java.util.List;

import integration.Discounts;

public class Sale {
    private List<SaleLineItem> lineItems = new ArrayList<>();
    private double totalPrice;
    private double totalVAT;
    private double saleDiscount;
    private double customerDiscountRate;

    public void addLineItem(Item item, int quantity, double itemDiscount) {
        lineItems.add(new SaleLineItem(item, quantity, itemDiscount));
        calculateTotal();
    }

    public void applySaleDiscount() {
        this.saleDiscount = Discounts.getSaleDiscount(totalPrice);
        calculateTotal();
    }

    public void applyCustomerDiscount(double discountRate) {
        this.customerDiscountRate = discountRate;
        calculateTotal();
    }

    private void calculateTotal() {
        double subtotal = lineItems.stream()
            .mapToDouble(SaleLineItem::getSubtotal)
            .sum();

        double postSaleDiscount = subtotal - saleDiscount;
        this.totalPrice = postSaleDiscount * (1 - customerDiscountRate);

        this.totalVAT = lineItems.stream()
            .mapToDouble(item -> item.getSubtotal() * item.getItem().getVatRate())
            .sum();
    }

    public double getTotalPrice() { return totalPrice; }
    public double getTotalVAT() { return totalVAT; }
    public List<SaleLineItem> getLineItems() { return lineItems; }
}
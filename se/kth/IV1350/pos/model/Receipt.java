package se.kth.IV1350.pos.model;

import java.util.List;

public class Receipt {
    private List<SaleLineItem> items;
    private double totalPrice;
    private double totalVAT;
    private double amountPaid;
    private double change;

    public Receipt(List<SaleLineItem> items, double totalPrice, double totalVAT,
                   double amountPaid, double change) {
        this.items = items;
        this.totalPrice = totalPrice;
        this.totalVAT = totalVAT;
        this.amountPaid = amountPaid;
        this.change = change;
    }

    // Getters
    public List<SaleLineItem> getItems() { return items; }
    public double getTotalPrice() { return totalPrice; }
    public double getTotalVAT() { return totalVAT; }
    public double getAmountPaid() { return amountPaid; }
    public double getChange() { return change; }
}
package se.kth.IV1350.pos.model;

public class SaleLineItem {
    private Item item;
    private int quantity;
    private double itemDiscount;

    public SaleLineItem(Item item, int quantity, double itemDiscount) {
        this.item = item;
        this.quantity = quantity;
        this.itemDiscount = itemDiscount;
    }

    public double getSubtotal() {
        double basePrice = item.getPrice() * quantity;
        return basePrice - (basePrice * itemDiscount);
    }

    public Item getItem() { return item; }
    public int getQuantity() { return quantity; }
}
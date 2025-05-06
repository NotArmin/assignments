package se.kth.IV1350.pos.model;

public class Item {
    private int itemID;
    private String description;
    private double price;
    private double vatRate;

    public Item(int itemID, String description, double price, double vatRate) {
        this.itemID = itemID;
        this.description = description;
        this.price = price;
        this.vatRate = vatRate;
    }

    public int getItemID() { return itemID; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public double getVatRate() { return vatRate; }
}
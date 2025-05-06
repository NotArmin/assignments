package se.kth.IV1350.pos.view;

import controller.Controller;
import model.Item;
import model.Receipt;
import model.SaleLineItem;


public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void displayItemDetails(Item item, double discount) {
        System.out.printf("Item added: %s | Price: $%.2f | Discount: %.0f%%%n",
            item.getDescription(),
            item.getPrice(),
            discount * 100
        );
    }

    public void showTotal(double total) {
        System.out.printf("Current total: $%.2f%n", total);
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }

    public void displayReceipt(Receipt receipt) {
        System.out.println("\n=== RECEIPT ===");
        System.out.println("Items:");
        for(SaleLineItem item : receipt.getItems()) {
            System.out.printf("- %s (x%d) @ $%.2f → $%.2f%n",
                item.getItem().getDescription(),
                item.getQuantity(),
                item.getItem().getPrice(),
                item.getSubtotal()
            );
        }
        System.out.printf("Total: $%.2f%n", receipt.getTotalPrice());
        System.out.printf("VAT: $%.2f%n", receipt.getTotalVAT());
        System.out.printf("Amount Paid: $%.2f%n", receipt.getAmountPaid());
        System.out.printf("Change: $%.2f%n", receipt.getChange());
    }
}
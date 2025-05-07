package se.kth.IV1350.pos.startup;

import se.kth.IV1350.pos.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.startSale(123, 1, "2023-10-05");
        
        // Scan items
        controller.enterItemID(1001, 5);    // Has 5% item discount
        controller.enterItemID(1001, 5);    // Increased quantity
        controller.enterItemID(1003, 5);    // No discount
        controller.enterItemID(1002, 2);    // Has 5% item discount
        controller.enterItemID(9999, 1);    // Invalid item
        
        // End sale to apply sale discount
        controller.endSale();
        
        // Apply customer discount (ID 555 gets 5%)
        controller.applyCustDiscount(555);
        
        // Process payment
        controller.processPayment(200.00);
    }
}
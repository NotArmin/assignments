package se.kth.IV1350.pos.controller;

import dbhandler.DbHandler;
import model.*;
import view.View;

public class Controller {
    private Sale currentSale;
    private DbHandler dbHandler;
    private View view;

    public Controller() {
        this.dbHandler = new DbHandler();
        this.view = new View(this);
    }

    public void startSale(int employeeID, int registerID, String dateTime) {
        currentSale = new Sale();
    }

    public void enterItemID(int itemID, int quantity) {
        Item item = dbHandler.getItem(itemID);
        if(item != null) {
            double itemDiscount = dbHandler.getItemDiscount(itemID);
            currentSale.addLineItem(item, quantity, itemDiscount);
            view.displayItemDetails(item, itemDiscount);
            view.showTotal(currentSale.getTotalPrice());
        } else {
            view.showError("Item not found!");
        }
    }

    public void endSale() {
        currentSale.applySaleDiscount();
        view.showTotal(currentSale.getTotalPrice());
    }

    public void applyDiscount(int customerID) {
        double discount = dbHandler.getCustomerDiscount(customerID);
        currentSale.applyCustomerDiscount(discount);
        view.showTotal(currentSale.getTotalPrice());
    }

    public void processPayment(double amountPaid) {
        double change = amountPaid - currentSale.getTotalPrice();
        Receipt receipt = generateReceipt(amountPaid, change);
        
        dbHandler.updateInventory(currentSale);
        dbHandler.updateAccounting(currentSale.getTotalPrice());
        
        view.displayReceipt(receipt);
    }

    private Receipt generateReceipt(double amountPaid, double change) {
        return new Receipt(
            currentSale.getLineItems(),
            currentSale.getTotalPrice(),
            currentSale.getTotalVAT(),
            amountPaid,
            change
        );
    }
}
package se.kth.IV1350.pos.dbhandler;

import integration.Accounting;
import integration.Discounts;
import integration.Inventory;
import model.Item;
import model.Sale;

public class DbHandler {
    public Item getItem(int itemID) {
        return Inventory.getItem(itemID);
    }

    public double getItemDiscount(int itemID) {
        return Discounts.getItemDiscountRate(itemID);
    }

    public double getCustomerDiscount(int customerID) {
        return Discounts.getCustomerDiscountRate(customerID);
    }

    public void updateInventory(Sale sale) {
        Inventory.decrementStock(sale);
    }

    public void updateAccounting(double amount) {
        Accounting.updateBalance(amount);
    }
}
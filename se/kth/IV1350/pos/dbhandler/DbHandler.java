package se.kth.IV1350.pos.dbhandler;

import se.kth.IV1350.pos.integration.Accounting;
import se.kth.IV1350.pos.integration.Discounts;
import se.kth.IV1350.pos.integration.Inventory;
import se.kth.IV1350.pos.model.Item;
import se.kth.IV1350.pos.model.Sale;

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
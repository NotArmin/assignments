package se.kth.IV1350.pos.integration;

import java.util.HashMap;
import java.util.Map;

import model.Item;
import model.Sale;

public class Inventory {
    private static final Map<Integer, Item> items = new HashMap<>();
    
    static {
        items.put(1001, new Item(1001, "Premium Coffee", 12.99, 0.25));
        items.put(1002, new Item(1002, "Artisan Tea", 8.99, 0.25));
        items.put(1003, new Item(1003, "Bottled Water", 2.99, 0.10));
    }

    public static Item getItem(int itemID) {
        return items.get(itemID);
    }

    public static void decrementStock(Sale sale) {
        // Implementation would update stock here
    }
}
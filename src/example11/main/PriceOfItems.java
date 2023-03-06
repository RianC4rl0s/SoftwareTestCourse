package example11.main;

import java.util.List;

// It navigates the list of items and calculates the unit price
// times the quantity of each item.
public class PriceOfItems implements PriceRule {
    @Override
    public double priceToAggregate(ShoppingCart cart) {
        double price = 0;
        List<Item> items = cart.getItems();
        for (Item item : items)
            price += item.getPricePerUnit() * item.getQuantity();
        return price;
    }
}
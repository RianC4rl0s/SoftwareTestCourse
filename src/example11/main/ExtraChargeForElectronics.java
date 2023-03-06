package example11.main;

import java.util.List;

// Check whether the cart contains any electronics. If so, we add the extra charge.
public class ExtraChargeForElectronics implements PriceRule {
    @Override
    public double priceToAggregate(ShoppingCart cart) {
        List<Item> items = cart.getItems();
        // Looks for any item whose type is equal to ELECTRONIC.
        boolean hasAnElectronicDevice = items.
                stream().
                anyMatch(it -> it.getType() == ItemType.ELECTRONIC);
        // If there is at least one such item, we return the extra charge.
        if(hasAnElectronicDevice)
            return 7.50;
        return 0;
    }
}

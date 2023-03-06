package example11.main;

import java.util.List;

// It aggregates all the price rules and calculates the final price.
// This class is flexible and can receive any
// combination of price rules.
public class FinalPriceCalculator {
    private final List<PriceRule> rules;

    public FinalPriceCalculator(List<PriceRule> rules) {
        this.rules = rules;
    }
    // It receives a ShoppingCart, passes it to all the price rules, and
    // returns the aggregated price.
    public double calculate(ShoppingCart cart) {
        double finalPrice = 0;
        // For each price rule, gets the price to add to the final price.
        for (PriceRule rule : rules) {
            finalPrice += rule.priceToAggregate(cart);
        }

        return finalPrice;
    }
}
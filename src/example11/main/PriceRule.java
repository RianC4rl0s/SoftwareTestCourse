package example11.main;

// Defining the contract that all the prices have in common.
public interface PriceRule {
    double priceToAggregate(ShoppingCart cart); // It receives a ShoppingCart and
                                                // returns the value that should be
                                                // aggregated to the final price of the shopping cart.
}

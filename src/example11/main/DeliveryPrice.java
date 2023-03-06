package example11.main;

public class DeliveryPrice implements PriceRule {
    @Override
    public double priceToAggregate(ShoppingCart cart) {

        // Gets the number of items in the cart.
        // The delivery price is based on this.
        int totalItems = cart.numberOfItems();

        // These if statements based on the requirements are
        // enough to return the price.
        if(totalItems == 0)
            return 0;
        if(totalItems >= 1 && totalItems <= 3)
            return 5;
        if(totalItems >= 4 && totalItems <= 10)
            return 12.5;

        // for the tool to get 100% coverage, use the code below.
        //if(totalItems == 0)
        //    return 0;
        //if(totalItems <= 3)
        //    return 5;
        //if(totalItems <= 10)
        //    return 12.5;

        return 20.0;
    }
}

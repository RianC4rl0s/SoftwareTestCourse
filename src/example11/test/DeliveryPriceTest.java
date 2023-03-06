package example11.test;

import example11.main.DeliveryPrice;
import example11.main.Item;
import example11.main.ItemType;
import example11.main.ShoppingCart;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DeliveryPriceTest {

    @ParameterizedTest
    @CsvSource({"0,0",
                "1,5",
                "3,5",
                "4,12.5",
               "10,12.5",
               "11,20"})
    void deliveryIsAccordingToTheNumberOfItems(int noOfItems, double expectedDeliveryPrice) {
        //Creates a shopping cart and adds the specified number
        //of items to it. The type, name, quantity, and unit price do not matter.
        ShoppingCart cart = new ShoppingCart();
        for(int i = 0; i < noOfItems; i++)
            cart.add(new Item(ItemType.OTHER, "ANY", 1, 1));
        // Calls the DeliveryPrice rule
        double price = new DeliveryPrice().priceToAggregate(cart);
        assertThat(price).isEqualTo(expectedDeliveryPrice);
    }
}
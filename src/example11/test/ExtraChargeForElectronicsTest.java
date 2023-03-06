package example11.test;

import example11.main.ExtraChargeForElectronics;
import example11.main.Item;
import example11.main.ItemType;
import example11.main.ShoppingCart;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

// The parameterized test will run a test with one electronic item in the cart and
// another test with two electronic items in the cart. We want to ensure that having
// multiple electronics in the cart does not incur incorrect extra charges.
public class ExtraChargeForElectronicsTest {

    @ParameterizedTest
    @CsvSource({"1", "2"})
    void chargeTheExtraPriceIfThereIsAnyElectronicInTheCart(int numberOfElectronics) {
        ShoppingCart cart = new ShoppingCart();
        for(int i = 0; i < numberOfElectronics; i++) {
            cart.add(new Item(ItemType.ELECTRONIC, "ANY ELECTRONIC", 1, 1));
        }

        double price = new ExtraChargeForElectronics().priceToAggregate(cart);
        assertThat(price).isEqualTo(7.50);
    }

    @Test
    void noExtraChargesIfNoElectronics() {
        ShoppingCart cart = new ShoppingCart();
        cart.add(new Item(ItemType.OTHER, "BOOK", 1, 1));
        cart.add(new Item(ItemType.OTHER, "CD", 1, 1));
        cart.add(new Item(ItemType.OTHER, "BABY TOY", 1, 1));

        double price = new ExtraChargeForElectronics().priceToAggregate(cart);
        assertThat(price).isEqualTo(0); // Asserts that nothing is charged.
    }

    @Test
    void noItems() {
        ShoppingCart cart = new ShoppingCart();
        double price = new ExtraChargeForElectronics().priceToAggregate(cart);
        assertThat(price).isEqualTo(0); // The shopping cart is empty, so nothing is charged.
    }
}
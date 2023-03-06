package example11.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// ShoppingCart holds a list of Items.
public class ShoppingCart {
    private final List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public int numberOfItems() {
        return items.size();
    }
}


package example11.main;

// An Item is composed of a name, a quantity, a price per unit,
// and a type indicating whether this item is a piece of electronics.
public class Item {

    private final ItemType type;
    private final String name;
    private final int quantity;
    private final double pricePerUnit;

    public Item(ItemType type, String name, int quantity, double pricePerUnit) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public ItemType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }
}
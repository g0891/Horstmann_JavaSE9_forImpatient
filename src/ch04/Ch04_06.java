package ch04;

import java.util.Objects;

public class Ch04_06 {
    public static void main(String[] args) {
        Item item1 = new Item("Pen", 10);
        DiscountedItem di1 = new DiscountedItem("Pen", 10, 5);
        DiscountedItem di2 = new DiscountedItem("Pen", 10, 20);

        System.out.println("Non transitive:");
        System.out.println("Supposed to be true: " + di1.equals(item1));
        System.out.println("Supposed to be true: " + item1.equals(di2));
        System.out.println("Supposed to be false: " + di1.equals(di2));



    }
}

class Item {
    private String description;
    private double price;

    public Item(String description, double price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price);
    }
}

class DiscountedItem extends Item {
    private double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (this.getClass() == o.getClass()) {
            DiscountedItem di = (DiscountedItem) o;
            return discount == di.discount;
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }
}
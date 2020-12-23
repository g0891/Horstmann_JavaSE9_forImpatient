package ch02;

import java.util.ArrayList;

public class Ch02_15 {
    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.addItem("Table", 2, 15);
        invoice.addItem("Chair", 4, 5);
        invoice.addItem("Carpet", 1,50);
        invoice.print();
    }


}

class Invoice {
    private static class Item {
        String description;
        int quantity;
        double unitPrice;

        double price() {
            return quantity * unitPrice;
        }
    }
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(String description, int quantity, double unitPrice) {
        Item newItem = new Item();
        newItem.description = description;
        newItem.quantity = quantity;
        newItem.unitPrice = unitPrice;
        items.add(newItem);
    }

    public void print() {
        System.out.println("INVOICE\n-------");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("Description: %s\tQuantity: %d\tUnit price: %.2f\n", items.get(i).description,
                     items.get(i).quantity, items.get(i).unitPrice);
        }
    }
}

package f_hashmaps;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {
        // Creating a HashMap to store key-value pairs
        Map<String, Integer> productStock = new HashMap<>();

        // 1. Adding elements (put method)
        productStock.put("Laptop", 50);
        productStock.put("Smartphone", 200);
        productStock.put("Tablet", 75);

        // 2. Accessing a value using key (get method)
        int laptopStock = productStock.get("Laptop");
        System.out.println("Laptop Stock: " + laptopStock);

        // 3. Checking if a key exists (containsKey method)
        if (productStock.containsKey("Smartphone")) {
            System.out.println("Smartphone is in stock");
        }

        // 4. Removing an entry (remove method)
        productStock.remove("Tablet");
        System.out.println("Tablet removed from stock");

        // 5. Iterating over the HashMap (entrySet method)
        for (Map.Entry<String, Integer> entry : productStock.entrySet()) {
            System.out.println("Product: " + entry.getKey() + ", Stock: " + entry.getValue());
        }

        // 6. Checking the size of the HashMap (size method)
        System.out.println("Total Products in Stock: " + productStock.size());

        // 7. Replacing an existing value (replace method)
        productStock.replace("Laptop", 45);
        System.out.println("Updated Laptop Stock: " + productStock.get("Laptop"));
    }
}

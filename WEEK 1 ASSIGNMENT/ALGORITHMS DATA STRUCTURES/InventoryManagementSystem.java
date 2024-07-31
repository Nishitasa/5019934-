/*Efficient data structures and algorithms are essential for handling large inventories because they enable quick data retrieval, storage, and management. */
/*Suitable Data Structures:
ArrayList: Good for dynamic arrays and allows fast random access. However, adding or removing elements can be slow if they are not at the end of the list.
HashMap: Ideal for key-value pairs and allows for fast retrieval, addition, and deletion operations due to its average constant-time complexity (O(1)) for these operations.
For efficient data retrieval and modification, a HashMap is a suitable choice for storing products.*/

import java.util.HashMap;
import java.util.Map;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: $" + price;
    }
}
class InventoryManager {
    private Map<Integer, Product> inventory = new HashMap<>();

    // Add a product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    // Update a product
    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete a product
    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Get a product
    public Product getProduct(int productId) {
        return inventory.get(productId);
    }

    // Display all products
    public void displayAllProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}
public class InventoryManagementSystem {

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Adding products
        Product prod1 = new Product(1, "Laptop", 10, 799.99);
        Product prod2 = new Product(2, "Smartphone", 20, 299.99);
        manager.addProduct(prod1);
        manager.addProduct(prod2);

        // Display all products
        System.out.println("All Products:");
        manager.displayAllProducts();

        // Updating a product
        prod1.setPrice(749.99);
        manager.updateProduct(prod1);

        // Display updated product
        System.out.println("\nUpdated Product:");
        System.out.println(manager.getProduct(1));

        // Deleting a product
        manager.deleteProduct(2);

        // Display all products after deletion
        System.out.println("\nAll Products After Deletion:");
        manager.displayAllProducts();
    }
}
// Analysis
/*
 * Time Complexity Analysis:
 * Add Operation: HashMap.put() has an average time complexity of O(1).
 * Update Operation: HashMap.get() followed by updating the product attributes
 * has an average time complexity of O(1).
 * Delete Operation: HashMap.remove() has an average time complexity of O(1).
 */
/*
 * To further optimize:
 * Ensure that the hash function used by the HashMap minimizes collisions.
 */
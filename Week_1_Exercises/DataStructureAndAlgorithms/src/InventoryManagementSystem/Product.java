package InventoryManagementSystem;

import java.util.HashMap;
import java.util.Scanner;

public class Product {
    int productId;
    String productName;
    double quantity;
    double price;

    public Product(int productId, String productName, double quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    static HashMap<Integer, Product> inventory = new HashMap<>();

    public static void addProduct(int productId, String productName, double quantity, double price) {
        if (!inventory.containsKey(productId)) {
            inventory.put(productId, new Product(productId, productName, quantity, price));
            System.out.println("The product with ID " + productId + " has been added.");
        } else {
            System.out.println("The product with ID " + productId + " already exists.");
            System.out.println("Do you want to update the quantity of the item? [Y/N]");
            Scanner scanVar = new Scanner(System.in);
            String response = scanVar.next();
            if (response.equalsIgnoreCase("Y")) {
                System.out.println("Enter the quantity to add:");
                double addQuantity = scanVar.nextDouble();
                updateQuantity(productId, addQuantity);
            }
            scanVar.close();
        }
        displayInventory();
    }

    public static void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
            System.out.println("The product with ID " + productId + " has been deleted.");
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
        displayInventory();
    }

    public static void updateQuantity(int productId, double quantityChange) {
        if (inventory.containsKey(productId)) {
            Product product = inventory.get(productId);
            Scanner scanVar = new Scanner(System.in);
            System.out.println("Do you want to update the quantity of the item? [1: increase  2: decrease]");
            int response = scanVar.nextInt();
            if (response == 1) {
                product.quantity += quantityChange;
            } else if (response == 2) {
                product.quantity -= quantityChange;
            } else {
                System.out.println("Please enter either 1 or 2.");
            }
            System.out.println("Updated product: " + product);
            scanVar.close();
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
        displayInventory();
    }

    public static void updatePrice(int productId, double priceChange) {
        if (inventory.containsKey(productId)) {
            Product product = inventory.get(productId);
            Scanner scanVar = new Scanner(System.in);
            System.out.println("Do you want to update the price of the item? [1: increase  2: decrease]");
            int response = scanVar.nextInt();
            if (response == 1) {
                product.price += priceChange;
            } else if (response == 2) {
                product.price -= priceChange;
            } else {
                System.out.println("Please enter either 1 or 2.");
            }
            System.out.println("Updated product: " + product);
            scanVar.close();
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
        displayInventory();
    }

    public static void updateProductName(int productId, String newProductName) {
        if (inventory.containsKey(productId)) {
            Product product = inventory.get(productId);
            Scanner scanVar = new Scanner(System.in);
            System.out.println("Do you want to update the name of the item? [Y/N]");
            String response = scanVar.next();
            if (response.equalsIgnoreCase("Y")) {
                product.productName = newProductName;
                System.out.println("Updated product: " + product);
            }
            scanVar.close();
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
        displayInventory();
    }

    public static void displayInventory() {
        System.out.println("------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-10s | %-10s |\n", "Product ID", "Product Name", "Quantity", "Price");
        System.out.println("------------------------------------------------------");
        for (Product product : inventory.values()) {
            System.out.printf("| %-10d | %-20s | %-10.2f | %-10.2f |\n", product.productId, product.productName,
                    product.quantity, product.price);
        }
        System.out.println("------------------------------------------------------");
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        Scanner scanVar = new Scanner(System.in);
        while (true) {
            System.out.println("----- Inventory Management System -----");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. Update Quantity of the Product");
            System.out.println("4. Update Price of the Product");
            System.out.println("5. Update Name of the Product");
            System.out.println("6. Display Inventory");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanVar.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int productId = scanVar.nextInt();
                    System.out.print("Enter Product Name: ");
                    String productName = scanVar.next();
                    System.out.print("Enter Product Quantity: ");
                    double quantity = scanVar.nextDouble();
                    System.out.print("Enter Product Price: ");
                    double price = scanVar.nextDouble();
                    addProduct(productId, productName, quantity, price);
                    break;
                case 2:
                    System.out.print("Enter Product ID: ");
                    int deleteId = scanVar.nextInt();
                    deleteProduct(deleteId);
                    break;
                case 3:
                    System.out.print("Enter Product ID: ");
                    int updateQuantityId = scanVar.nextInt();
                    System.out.print("Enter Quantity Change: ");
                    double quantityChange = scanVar.nextDouble();
                    updateQuantity(updateQuantityId, quantityChange);
                    break;
                case 4:
                    System.out.print("Enter Product ID: ");
                    int priceUpdateId = scanVar.nextInt();
                    System.out.print("Enter Price Change: ");
                    double priceChange = scanVar.nextDouble();
                    updatePrice(priceUpdateId, priceChange);
                    break;
                case 5:
                    System.out.print("Enter Product ID: ");
                    int nameUpdateId = scanVar.nextInt();
                    System.out.print("Enter New Product Name: ");
                    String newProductName = scanVar.next();
                    updateProductName(nameUpdateId, newProductName);
                    break;
                case 6:
                    displayInventory();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanVar.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

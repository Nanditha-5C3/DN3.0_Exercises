package sortingCustomerOrders;

import java.util.Scanner;

public class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public static void bubbleSort(Order[] custOrders, int size) {
        for (int i = 0; i < size - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (custOrders[j].totalPrice > custOrders[j + 1].totalPrice) {
                    Order temp = custOrders[j];
                    custOrders[j] = custOrders[j + 1];
                    custOrders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void quickSort(Order[] custOrders, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(custOrders, low, high);

            quickSort(custOrders, low, partitionIndex - 1);
            quickSort(custOrders, partitionIndex + 1, high);
        }
    }

    public static int partition(Order[] custOrders, int low, int high) {
        Order pivot = custOrders[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (custOrders[j].totalPrice <= pivot.totalPrice) {
                i++;
                Order temp = custOrders[i];
                custOrders[i] = custOrders[j];
                custOrders[j] = temp;
            }
        }
        Order temp = custOrders[i + 1];
        custOrders[i + 1] = custOrders[high];
        custOrders[high] = temp;

        return i + 1;
    }

    public static void display(Order[] custOrders) {
        for (Order order : custOrders) {
            System.out.println("Order ID: " + order.orderId + ", Customer Name: " + order.customerName + ", Total Price: $" + order.totalPrice);
        }
    }

    public static void main(String[] args) {
        Scanner scanVar = new Scanner(System.in);
        System.out.println("Enter the number of orders:");
        int size = scanVar.nextInt();
        Order[] custOrders = new Order[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the order id:");
            int orderId = scanVar.nextInt();
            scanVar.nextLine(); // consume newline
            System.out.println("Enter the Customer Name:");
            String name = scanVar.nextLine();
            System.out.println("Enter the total price:");
            double totalPrice = scanVar.nextDouble();
            custOrders[i] = new Order(orderId, name, totalPrice);
        }

        System.out.println("The array before sorting...");
        display(custOrders);

        System.out.println("The array after bubble sort...");
        bubbleSort(custOrders, size);
        display(custOrders);

        System.out.println("The array after quick sort...");
        quickSort(custOrders, 0, size - 1);
        display(custOrders);

        scanVar.close();
    }
}

package financialForecasting;

import java.util.Scanner;

public class FinancialForecast {

    // Recursive method to calculate future value
    public static double computeFutureValue(double initialAmount, double growthRate, int numYears) {
        if (numYears == 0) {
            return initialAmount;
        }
        return computeFutureValue(initialAmount * (1 + growthRate), growthRate, numYears - 1);
    }

    // Main method to interact with the FinancialForecast
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from user
        System.out.print("Enter initial principal amount: ");
        double initialAmount = scanner.nextDouble();
        System.out.print("Enter annual growth rate (as a decimal): ");
        double growthRate = scanner.nextDouble();
        System.out.print("Enter number of years: ");
        int numYears = scanner.nextInt();

        // Compute future value
        double futureValue = computeFutureValue(initialAmount, growthRate, numYears);
        System.out.printf("Future value after %d years is: %.2f\n", numYears, futureValue);

        scanner.close();
    }
}

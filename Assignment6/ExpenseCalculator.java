import java.util.Scanner;

public class ExpenseCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input quantity and price per item
        System.out.print("Enter the quantity purchased: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter the price per item: ");
        double price = scanner.nextDouble();

        // Calculate total expenses
        double totalExpenses = calculateTotalExpenses(quantity, price);

        // Display total expenses
        System.out.println("Total expenses: $" + totalExpenses);

        scanner.close();
    }

    public static double calculateTotalExpenses(int quantity, double price) {
        double totalExpenses = quantity * price;

        // Apply discount based on quantity
        if (quantity > 50) {
            totalExpenses *= 0.9; 
        } else if (quantity >= 25 && quantity <= 50) {
            totalExpenses *= 0.95; 
        }

        return totalExpenses;
    }
}

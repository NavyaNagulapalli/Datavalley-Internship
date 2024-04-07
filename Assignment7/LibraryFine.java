import java.util.Scanner;

public class LibraryFine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of days late
        System.out.print("Enter the number of days late: ");
        int daysLate = scanner.nextInt();

        // Calculate fine based on number of days late
        double fine = 0;
        if (daysLate >= 1 && daysLate <= 7) {
            fine = 0.5 * daysLate;
        } else if (daysLate >= 8 && daysLate <= 14) {
            fine = 1 * daysLate;
        } else if (daysLate > 14 && daysLate <= 21) {
            fine = 5 * daysLate;
        } else if (daysLate > 21) {
            System.out.println("Your membership has been canceled due to late return.");
            System.exit(0); // Exit the program
        } else {
            System.out.println("No fine is applicable.");
            System.exit(0); // Exit the program
        }

        // Display fine
        System.out.println("Fine: Rs. " + fine);

        scanner.close();
    }
}

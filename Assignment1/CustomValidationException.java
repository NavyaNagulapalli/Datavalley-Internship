import java.util.Scanner;

class CustomValidationException extends Exception {
    public CustomValidationException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        try {
            validateNumber(number);
        } catch (CustomValidationException e) {
            System.out.println("Caught CustomValidationException: " + e.getMessage());
        }

        scanner.close();
    }

    public static void validateNumber(int number) throws CustomValidationException {
        if (number < 0) {
            throw new CustomValidationException("Number cannot be negative");
        } else {
            System.out.println("Number is valid: " + number);
        }
    }
}

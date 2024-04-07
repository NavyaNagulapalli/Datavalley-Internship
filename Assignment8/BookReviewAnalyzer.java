import java.util.*;

class Book {
    private String title;
    private int rating;

    public Book(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}

public class BookReviewAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Book> books = new ArrayList<>();

        // Input number of books
        System.out.print("Enter the number of books: ");
        int numBooks = scanner.nextInt();

        // Input book details
        for (int i = 0; i < numBooks; i++) {
            System.out.println("\nEnter details for book " + (i + 1) + ":");
            System.out.print("Enter title: ");
            String title = scanner.next();
            System.out.print("Enter rating (out of 10): ");
            int rating = scanner.nextInt();

            Book book = new Book(title, rating);
            books.add(book);
        }

        // Analyze book reviews
        int[] ratingRanges = {1, 5, 6, 10}; // Rating ranges (1-5 stars, 6-10 stars)
        int[] ratingCounts = new int[ratingRanges.length / 2]; // Array to store count of books within each rating range
        int positiveReviews = 0;
        int neutralReviews = 0;
        int negativeReviews = 0;

        for (Book book : books) {
            int rating = book.getRating();

            // Count books within rating ranges
            for (int i = 0; i < ratingRanges.length; i += 2) {
                if (rating >= ratingRanges[i] && rating <= ratingRanges[i + 1]) {
                    ratingCounts[i / 2]++;
                    break;
                }
            }

            // Categorize reviews as positive, neutral, or negative
            if (rating >= 7) {
                positiveReviews++;
            } else if (rating >= 4 && rating <= 6) {
                neutralReviews++;
            } else {
                negativeReviews++;
            }
        }

        // Display results
        System.out.println("\nBook Review Analysis:");
        for (int i = 0; i < ratingCounts.length; i++) {
            System.out.println("Number of books rated " + ratingRanges[2 * i] + "-" + ratingRanges[2 * i + 1] + ": " + ratingCounts[i]);
        }
        System.out.println("Positive reviews: " + positiveReviews);
        System.out.println("Neutral reviews: " + neutralReviews);
        System.out.println("Negative reviews: " + negativeReviews);

        scanner.close();
    }
}

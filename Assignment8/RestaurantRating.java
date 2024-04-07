import java.util.*;

public class RestaurantRating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> ratings = new ArrayList<>();

        // Input number of restaurants
        System.out.print("Enter the number of restaurants: ");
        int numRestaurants = scanner.nextInt();

        // Input ratings
        for (int i = 0; i < numRestaurants; i++) {
            System.out.print("Enter rating for restaurant " + (i + 1) + ": ");
            double rating = scanner.nextDouble();
            ratings.add(rating);
        }

        // Calculate average rating
        double averageRating = calculateAverage(ratings);

        // Calculate number of restaurants rated within specific ranges
        int[] ratingRanges = {1, 5, 6, 10}; // Rating ranges (1-5, 6-10)
        int[] ratingCounts = new int[ratingRanges.length / 2]; // Array to store count of restaurants within each range

        for (double rating : ratings) {
            for (int i = 0; i < ratingRanges.length; i += 2) {
                if (rating >= ratingRanges[i] && rating <= ratingRanges[i + 1]) {
                    ratingCounts[i / 2]++;
                    break;
                }
            }
        }

        // Calculate average rating for each range
        Map<String, Double> averageRatings = new HashMap<>();
        for (int i = 0; i < ratingCounts.length; i++) {
            double totalRating = 0;
            int count = 0;
            for (double rating : ratings) {
                if (rating >= ratingRanges[i * 2] && rating <= ratingRanges[i * 2 + 1]) {
                    totalRating += rating;
                    count++;
                }
            }
            if (count > 0) {
                double avgRating = totalRating / count;
                averageRatings.put(ratingRanges[i * 2] + "-" + ratingRanges[i * 2 + 1], avgRating);
            }
        }

        // Display results
        System.out.println("\nRestaurant Rating Analysis:");
        System.out.println("Average rating: " + averageRating);
        for (int i = 0; i < ratingCounts.length; i++) {
            System.out.println("Number of restaurants rated " + ratingRanges[i * 2] + "-" + ratingRanges[i * 2 + 1] + ": " + ratingCounts[i]);
            if (averageRatings.containsKey(ratingRanges[i * 2] + "-" + ratingRanges[i * 2 + 1])) {
                System.out.println("Average rating for " + ratingRanges[i * 2] + "-" + ratingRanges[i * 2 + 1] + ": " + averageRatings.get(ratingRanges[i * 2] + "-" + ratingRanges[i * 2 + 1]));
            } else {
                System.out.println("No restaurants in this rating range.");
            }
        }

        scanner.close();
    }

    // Method to calculate average rating
    private static double calculateAverage(List<Double> ratings) {
        double sum = 0;
        for (double rating : ratings) {
            sum += rating;
        }
        return sum / ratings.size();
    }
}

import java.util.*;

class Movie {
    private String title;
    private String rating;
    private double ratingValue;

    public Movie(String title, String rating, double ratingValue) {
        this.title = title;
        this.rating = rating;
        this.ratingValue = ratingValue;
    }

    public String getRating() {
        return rating;
    }

    public double getRatingValue() {
        return ratingValue;
    }
}

public class MovieAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Movie> movies = new ArrayList<>();

        // Input number of movies
        System.out.print("Enter the number of movies: ");
        int numMovies = scanner.nextInt();

        // Input movie details
        for (int i = 0; i < numMovies; i++) {
            System.out.println("\nEnter details for movie " + (i + 1) + ":");
            System.out.print("Enter title: ");
            String title = scanner.next();
            System.out.print("Enter rating (e.g., PG, PG-13, R): ");
            String rating = scanner.next();
            System.out.print("Enter rating value (out of 10): ");
            double ratingValue = scanner.nextDouble();

            Movie movie = new Movie(title, rating, ratingValue);
            movies.add(movie);
        }

        // Analyze movies
        Map<String, Integer> movieCounts = new HashMap<>();
        Map<String, Double> averageRatings = new HashMap<>();

        for (Movie movie : movies) {
            String rating = movie.getRating();
            double ratingValue = movie.getRatingValue();

            // Update movie counts
            movieCounts.put(rating, movieCounts.getOrDefault(rating, 0) + 1);

            // Update total rating and count for each category
            averageRatings.put(rating, averageRatings.getOrDefault(rating, 0.0) + ratingValue);
        }

        // Calculate average rating for each category
        for (String rating : averageRatings.keySet()) {
            double totalRating = averageRatings.get(rating);
            int movieCount = movieCounts.get(rating);
            double averageRating = totalRating / movieCount;
            averageRatings.put(rating, averageRating);
        }

        // Display results
        System.out.println("\nMovie Analysis:");
        for (String rating : movieCounts.keySet()) {
            System.out.println("Movies rated " + rating + ": " + movieCounts.get(rating));
            System.out.println("Average rating for " + rating + ": " + averageRatings.get(rating));
        }

        scanner.close();
    }
}

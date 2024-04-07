import java.util.*;

public class TestScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> scores = new ArrayList<>();

        // Input number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Input test scores
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter test score for student " + (i + 1) + ": ");
            int score = scanner.nextInt();
            scores.add(score);
        }

        // Calculate average score
        double averageScore = calculateAverage(scores);

        // Sort the scores
        Collections.sort(scores);

        // Calculate number of students above, at, and below the average
        int aboveAverageCount = 0;
        int atAverageCount = 0;
        int belowAverageCount = 0;

        for (int score : scores) {
            if (score > averageScore) {
                aboveAverageCount++;
            } else if (score == averageScore) {
                atAverageCount++;
            } else {
                belowAverageCount++;
            }
        }

        // Calculate median score for each group
        double medianAboveAverage = calculateMedian(scores, aboveAverageCount);
        double medianAtAverage = calculateMedian(scores, atAverageCount);
        double medianBelowAverage = calculateMedian(scores, belowAverageCount);

        // Display results
        System.out.println("\nTest Score Analysis:");
        System.out.println("Number of students above the average: " + aboveAverageCount + ", Median: " + medianAboveAverage);
        System.out.println("Number of students at the average: " + atAverageCount + ", Median: " + medianAtAverage);
        System.out.println("Number of students below the average: " + belowAverageCount + ", Median: " + medianBelowAverage);

        scanner.close();
    }

    // Method to calculate average score
    private static double calculateAverage(List<Integer> scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    }

    // Method to calculate median score for a group
    private static double calculateMedian(List<Integer> scores, int count) {
        int startIndex = scores.size() - count;
        int endIndex = startIndex + count - 1;

        if (count % 2 == 0) {
            return (

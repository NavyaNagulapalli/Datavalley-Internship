import java.util.*;

class Project {
    private String studentName;
    private int completionTime; // in days

    public Project(String studentName, int completionTime) {
        this.studentName = studentName;
        this.completionTime = completionTime;
    }

    public int getCompletionTime() {
        return completionTime;
    }
}

public class ProjectAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Project> projects = new ArrayList<>();

        // Input number of projects
        System.out.print("Enter the number of projects: ");
        int numProjects = scanner.nextInt();

        // Input project details
        for (int i = 0; i < numProjects; i++) {
            System.out.println("\nEnter details for project " + (i + 1) + ":");
            System.out.print("Enter student name: ");
            String studentName = scanner.next();
            System.out.print("Enter completion time (in days): ");
            int completionTime = scanner.nextInt();

            Project project = new Project(studentName, completionTime);
            projects.add(project);
        }

        // Analyze projects
        int onTimeCount = 0;
        int lateCount = 0;
        int earlyCount = 0;
        int totalCompletionTime = 0;

        for (Project project : projects) {
            totalCompletionTime += project.getCompletionTime();

            if (project.getCompletionTime() <= 7) {
                onTimeCount++;
            } else if (project.getCompletionTime() > 7 && project.getCompletionTime() <= 14) {
                lateCount++;
            } else {
                earlyCount++;
            }
        }

        // Calculate average completion time
        double averageCompletionTime = (double) totalCompletionTime / numProjects;

        // Display results
        System.out.println("\nProject Analysis:");
        System.out.println("Projects completed on time: " + onTimeCount);
        System.out.println("Projects completed late: " + lateCount);
        System.out.println("Projects completed early: " + earlyCount);
        System.out.println("Average completion time (in days): " + averageCompletionTime);

        scanner.close();
    }
}

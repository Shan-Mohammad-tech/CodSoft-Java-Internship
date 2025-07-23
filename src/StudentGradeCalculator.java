

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("📚 STUDENT GRADE CALCULATOR 📚");
        System.out.println("==============================");

        // Get number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Validate input
        while (numSubjects <= 0) {
            System.out.println("Invalid number! Please enter a positive number of subjects.");
            System.out.print("Enter the number of subjects: ");
            numSubjects = scanner.nextInt();
        }

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in Subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();

            // Validate marks
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Please enter a value between 0 and 100.");
                System.out.print("Enter marks obtained in Subject " + (i + 1) + " (out of 100): ");
                marks[i] = scanner.nextInt();
            }

            totalMarks += marks[i];
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Determine grade
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B+";
        } else if (averagePercentage >= 60) {
            grade = "B";
        } else if (averagePercentage >= 50) {
            grade = "C";
        } else if (averagePercentage >= 40) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display results
        System.out.println("\n📊 RESULTS SUMMARY 📊");
        System.out.println("----------------------");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        // Additional feedback based on grade
        System.out.println("\nPerformance Feedback: " + getFeedback(grade));

        scanner.close();
    }

    private static String getFeedback(String grade) {
        switch (grade) {
            case "A+": return "Outstanding performance! Keep up the excellent work! 🌟";
            case "A": return "Excellent work! You're doing great! 👍";
            case "B+": return "Very good! You're on the right track! 👏";
            case "B": return "Good effort! There's room for improvement. 🙂";
            case "C": return "Average performance. Try to study more. 📖";
            case "D": return "Below average. Please focus on your studies. 💪";
            case "F": return "You need to work harder. Seek help if needed. ❗";
            default: return "";
        }
    }
}
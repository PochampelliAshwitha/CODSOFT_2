import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numSubjects = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter the number of subjects: ");
            try {
                numSubjects = scanner.nextInt();
                if (numSubjects <= 0) {
                    System.out.println("Please enter a positive integer.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); 
            }
        }

        double[] marks = new double[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            double mark = -1; 
            while (mark < 0 || mark > 100) {
                System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
                try {
                    mark = scanner.nextDouble();
                    if (mark < 0 || mark > 100) {
                        System.out.println("Invalid input. Please enter marks between 0 and 100.");
                    } else {
                        marks[i] = mark; 
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); 
                }
            }
        }

        double totalMarks = 0;
        for (double mark : marks) {
            totalMarks += mark;
        }

        double averagePercentage = totalMarks / numSubjects;

        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.printf("Total Marks: %.2f\n", totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
/*STUDENT GRADE CALCULATOR */

/*  
Input: Take marks obtained (out of 100) in each subject.
Calculate Total Marks: Sum up the marks obtained in all subjects.
Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
average percentage.
Grade Calculation: Assign grades based on the average percentage achieved.
Display Results: Show the total marks, average percentage, and the corresponding grade to the user
*/

/*
 * Example:-
 * The subjects (as not mentioned can be considered as following)
 * 1)Maths(Standard)
 * 2)Science
 * 3)Social Science
 * 4)English
 * 5)Hindi
 * 
 */

 import java.util.*;

 public class StudentGradeCalculator {
 
     public static void main(String[] args) {

         List<String> subjects = new ArrayList<>();

         Scanner sc = new Scanner(System.in);
 
         System.out.println("Enter the total number of Subjects:");
         int numberOfSubjects = sc.nextInt();
         sc.nextLine(); 
 
         for (int i = 1; i <= numberOfSubjects; i++) {
             System.out.println("Enter the name of Subject " + i + ":");
             String nameOfSubject = sc.nextLine();
             subjects.add(nameOfSubject);
         }
 
         long totalMarks = 0;
 
         for (int i = 0; i < numberOfSubjects; i++) {
             System.out.println("Enter the marks for " + subjects.get(i) + " (out of 100):");
             long marks = sc.nextLong();
 
             // Validate marks input (assuming marks are out of 100)
             while (marks < 0 || marks > 100) {
                 System.err.println("Invalid Marks! Marks should be between 0 and 100.");
                 System.out.println("Enter valid marks for " + subjects.get(i) + ":");
                 marks = sc.nextLong();
             }
 
             totalMarks += marks;
         }
 
         // Calculate average percentage
         double averagePercentage = (double) totalMarks / numberOfSubjects;
 
         // Display total marks and average percentage
         System.out.println("\nStudent Grade Card:");
         System.out.println("Total Marks: " + totalMarks);
         System.out.printf("Average Percentage: %.2f%% \n", averagePercentage);
 
         // Grade Calculation 
         System.out.print("Grade: ");
 
         if (averagePercentage >= 90) {
             System.out.println("A+");
         } else if (averagePercentage >= 80) {
             System.out.println("A");
         } else if (averagePercentage >= 70) {
             System.out.println("B");
         } else if (averagePercentage >= 60) {
             System.out.println("C");
         } else if (averagePercentage >= 50) {
             System.out.println("D");
         } else {
             System.out.println("F");
         }
 
         sc.close();
     }
 }
 

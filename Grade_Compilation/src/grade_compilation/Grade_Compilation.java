
package grade_compilation;

import java.util.*;
//hi

public class Grade_Compilation {
    static List<String> students = new ArrayList<>();
    static List<Integer> grades = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int choice = 0;
        
        do {
            System.out.println("Student Grade Management System");
            System.out.println("1. Add Students");
            System.out.println("2. View All Students");
            System.out.println("3. Show Average Grade");
            System.out.println("4. Show Highest and Lowest Grade");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice > 0 && choice < 6) {
                    switch (choice) {
                        case 1 -> addStudents(scanner);
                        case 2 -> viewStudents();
                        case 3 -> averageGrade();
                        case 4 -> highestLowestGrade();
                        case 5 -> System.out.println("Exiting program...");
                    }
                } else {
                    System.out.println("Only input numbers between (1-5).\n");
                    scanner.nextLine();
                }
            } else {
                System.out.println("Invalid input. Please input a valid integer.\n");
                scanner.nextLine();
            }
        } while (choice != 5);
        
        scanner.close();
    }
    static void addStudents(Scanner scanner) {
        String name;
        Integer grade;
        
        System.out.print("Enter Student Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Student Grade: ");
        grade = scanner.nextInt();
        
        students.add(name);
        grades.add(grade); 
        
        System.out.println("Student added successfully.\n");
    }
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No Student To Display.\n");
            return;
        }
        
        System.out.println("Student List:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i) + " - Grade: " + grades.get(i));
        }
        System.out.println("");
    }
    static void averageGrade() {
        int sum = 0;
        double average;
        
        if (students.isEmpty()) {
            System.out.println("No Average Grade to Display.\n");
            return;
        }
        
        for (int grade : grades) {
            sum += grade;
        }
        
        average = sum / grades.size();
        System.out.println("Average Grade: " + average + "\n");
    }
    static void highestLowestGrade() {
        if (grades.isEmpty()) {
            System.out.println("There are no grade to show.");
            return;
        }
        
        int highest = grades.get(0);
        int lowest = grades.get(0);
        String topStudent = students.get(0);
        String lowStudent = students.get(0);
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) > highest) {
                highest = grades.get(i);
                topStudent = students.get(i);
            }
            if (grades.get(i) < lowest) {
                lowest = grades.get(i);
                lowStudent = students.get(i);
            }
        }
        
        System.out.println("Highest Grade: " + highest + " by " + topStudent);
        System.out.println("Lowest Grade: " + lowest + " by " + lowStudent);
        System.out.println("");
    }
}

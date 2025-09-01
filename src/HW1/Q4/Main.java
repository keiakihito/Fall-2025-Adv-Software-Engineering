/**
 * Main driver class for CS5800 HW1 Q4 - Aggregation ("HAS-A" Relationship) demonstration.
 * This program demonstrates aggregation relationships between Course, Instructor, and Textbook classes.
 * It shows both single and multiple object aggregation scenarios.
 * 
 * @author CS5800 Student
 * @version 1.0
 * @since 2025
 */
public class Main {
    /**
     * Main method that demonstrates aggregation relationships.
     * Creates and displays courses with both single and multiple instructors/textbooks.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("CS5800 HW1 Q4 - Aggregation (\"HAS-A\" Relationship)");
        System.out.println("====================================================\n");
        
        // Part 1: Create and display a Course with single Instructor and Textbook
        System.out.println("Part 1: Course with Single Instructor and Textbook");
        System.out.println("---------------------------------------------------");
        
        Instructor instructor1 = new Instructor("Nima", "Davarpanah", "3-2636");
        Textbook textbook1 = new Textbook("Clean Code", "Robert C. Martin", "Prentice Hall");
        Course course1 = new Course("Advanced Software Engineering", instructor1, textbook1);
        
        course1.print();
        System.out.println();
        
        // Part 2: Create and display a Course with multiple Instructors and Textbooks
        System.out.println("Part 2: Course with Multiple Instructors and Textbooks");
        System.out.println("------------------------------------------------------");
        
        Instructor[] instructors = {
            new Instructor("Nima", "Davarpanah", "3-2636"),
            new Instructor("Jane", "Smith", "2-100"),
        };
        
        Textbook[] textbooks = {
            new Textbook("Clean Code", "Robert C. Martin", "Prentice Hall"),
            new Textbook("Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma", "Addison-Wesley"),
        };
        
        Course course2 = new Course("Advanced Software Engineering", instructors, textbooks);
        course2.print();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Demonstration completed successfully!");
        System.out.println("Both single and multiple aggregation relationships shown.");
    }
}
public class CourseTest {
    private static int testsPassed = 0;
    private static int totalTests = 0;
    
    public static void runTests() {
        System.out.println("Testing Course Class");
        System.out.println("====================");
        
        testConstructorSingleInstructorAndTextbook();
        testGettersAndSetters();
        testPrintMethod();
        testConstructorMultipleInstructorsAndTextbooks();
        testPrintMethodMultiple();
        
        System.out.println("\nCourse Test Results: " + testsPassed + "/" + totalTests + " tests passed\n");
    }
    
    private static void testConstructorSingleInstructorAndTextbook() {
        try {
            Instructor instructor = new Instructor("Nima", "Davarpanah", "3-2636");
            Textbook textbook = new Textbook("Clean Code", "Robert C. Martin", "Prentice Hall");
            Course course = new Course("Advanced Software Engineering", instructor, textbook);
            
            assert course.getCourseName().equals("Advanced Software Engineering") : "Constructor failed for courseName";
            assert course.getInstructor().equals(instructor) : "Constructor failed for instructor";
            assert course.getTextbook().equals(textbook) : "Constructor failed for textbook";
            
            System.out.println("✓ Constructor test (single instructor/textbook) passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Constructor test (single instructor/textbook) failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testGettersAndSetters() {
        try {
            Instructor instructor1 = new Instructor("John", "Smith", "1-100");
            Textbook textbook1 = new Textbook("Book1", "Author1", "Publisher1");
            Course course = new Course("Test Course", instructor1, textbook1);
            
            // Test setters
            Instructor instructor2 = new Instructor("Jane", "Doe", "2-200");
            Textbook textbook2 = new Textbook("Book2", "Author2", "Publisher2");
            course.setCourseName("New Course Name");
            course.setInstructor(instructor2);
            course.setTextbook(textbook2);
            
            // Test getters
            assert course.getCourseName().equals("New Course Name") : "Setter/Getter failed for courseName";
            assert course.getInstructor().equals(instructor2) : "Setter/Getter failed for instructor";
            assert course.getTextbook().equals(textbook2) : "Setter/Getter failed for textbook";
            
            System.out.println("✓ Getters and setters test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Getters and setters test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testPrintMethod() {
        try {
            Instructor instructor = new Instructor("Nima", "Davarpanah", "3-2636");
            Textbook textbook = new Textbook("Clean Code", "Robert C. Martin", "Prentice Hall");
            Course course = new Course("Advanced Software Engineering", instructor, textbook);
            
            System.out.println("Testing print method output:");
            course.print();
            System.out.println("✓ Print method test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Print method test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testConstructorMultipleInstructorsAndTextbooks() {
        try {
            Instructor[] instructors = {
                new Instructor("Nima", "Davarpanah", "3-2636"),
                new Instructor("Jane", "Smith", "2-100")
            };
            Textbook[] textbooks = {
                new Textbook("Clean Code", "Robert C. Martin", "Prentice Hall"),
                new Textbook("Design Patterns", "Gang of Four", "Addison-Wesley")
            };
            Course course = new Course("Advanced Software Engineering", instructors, textbooks);
            
            assert course.getCourseName().equals("Advanced Software Engineering") : "Constructor failed for courseName";
            assert course.getInstructors().length == 2 : "Constructor failed for instructors array";
            assert course.getTextbooks().length == 2 : "Constructor failed for textbooks array";
            
            System.out.println("✓ Constructor test (multiple instructors/textbooks) passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Constructor test (multiple instructors/textbooks) failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testPrintMethodMultiple() {
        try {
            Instructor[] instructors = {
                new Instructor("Nima", "Davarpanah", "3-2636"),
                new Instructor("Jane", "Smith", "2-100")
            };
            Textbook[] textbooks = {
                new Textbook("Clean Code", "Robert C. Martin", "Prentice Hall"),
                new Textbook("Design Patterns", "Gang of Four", "Addison-Wesley")
            };
            Course course = new Course("Advanced Software Engineering", instructors, textbooks);
            
            System.out.println("Testing print method output (multiple):");
            course.print();
            System.out.println("✓ Print method test (multiple) passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Print method test (multiple) failed: " + e.getMessage());
        }
        totalTests++;
    }
}
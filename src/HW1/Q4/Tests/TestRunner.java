public class TestRunner {
    public static void main(String[] args) {
        System.out.println("Running Adv. Software Engineering Fall 2025 HW1 Q4 Test Suite");
        System.out.println("=================================\n");
        
        // Run tests for individual classes
        InstructorTest.runTests();
        TextbookTest.runTests();
        CourseTest.runTests();
        
        System.out.println("All tests completed!");
    }
}
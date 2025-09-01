public class InstructorTest {
    private static int testsPassed = 0;
    private static int totalTests = 0;
    
    public static void runTests() {
        System.out.println("Testing Instructor Class");
        System.out.println("========================");
        
        testConstructor();
        testGettersAndSetters();
        testInputValidation();
        
        System.out.println("\nInstructor Test Results: " + testsPassed + "/" + totalTests + " tests passed\n");
    }
    
    private static void testConstructor() {
        try {
            Instructor instructor = new Instructor("Nima", "Davarpanah", "3-2636");
            assert instructor.getFirstName().equals("Nima") : "Constructor failed for firstName";
            assert instructor.getLastName().equals("Davarpanah") : "Constructor failed for lastName";
            assert instructor.getOfficeNumber().equals("3-2636") : "Constructor failed for officeNumber";
            System.out.println("✓ Constructor test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Constructor test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testGettersAndSetters() {
        try {
            Instructor instructor = new Instructor("John", "Smith", "1-100");
            
            // Test setters
            instructor.setFirstName("Jane");
            instructor.setLastName("Doe");
            instructor.setOfficeNumber("2-200");
            
            // Test getters
            assert instructor.getFirstName().equals("Jane") : "Setter/Getter failed for firstName";
            assert instructor.getLastName().equals("Doe") : "Setter/Getter failed for lastName";
            assert instructor.getOfficeNumber().equals("2-200") : "Setter/Getter failed for officeNumber";
            
            System.out.println("✓ Getters and setters test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Getters and setters test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testInputValidation() {
        try {
            // Test with null values
            try {
                Instructor instructor = new Instructor(null, "Doe", "1-100");
                System.out.println("✗ Input validation test failed: Should reject null firstName");
            } catch (IllegalArgumentException e) {
                System.out.println("✓ Input validation test passed: Correctly rejected null firstName");
                testsPassed++;
            }
        } catch (Exception e) {
            System.out.println("✗ Input validation test failed: " + e.getMessage());
        }
        totalTests++;
    }
}
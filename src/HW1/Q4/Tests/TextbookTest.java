public class TextbookTest {
    private static int testsPassed = 0;
    private static int totalTests = 0;
    
    public static void runTests() {
        System.out.println("Testing Textbook Class");
        System.out.println("======================");
        
        testConstructor();
        testGettersAndSetters();
        testInputValidation();
        
        System.out.println("\nTextbook Test Results: " + testsPassed + "/" + totalTests + " tests passed\n");
    }
    
    private static void testConstructor() {
        try {
            Textbook textbook = new Textbook("Clean Code", "Robert C. Martin", "Prentice Hall");
            assert textbook.getTitle().equals("Clean Code") : "Constructor failed for title";
            assert textbook.getAuthor().equals("Robert C. Martin") : "Constructor failed for author";
            assert textbook.getPublisher().equals("Prentice Hall") : "Constructor failed for publisher";
            System.out.println("✓ Constructor test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Constructor test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testGettersAndSetters() {
        try {
            Textbook textbook = new Textbook("Title1", "Author1", "Publisher1");
            
            // Test setters
            textbook.setTitle("New Title");
            textbook.setAuthor("New Author");
            textbook.setPublisher("New Publisher");
            
            // Test getters
            assert textbook.getTitle().equals("New Title") : "Setter/Getter failed for title";
            assert textbook.getAuthor().equals("New Author") : "Setter/Getter failed for author";
            assert textbook.getPublisher().equals("New Publisher") : "Setter/Getter failed for publisher";
            
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
                Textbook textbook = new Textbook(null, "Author", "Publisher");
                System.out.println("✗ Input validation test failed: Should reject null title");
            } catch (IllegalArgumentException e) {
                System.out.println("✓ Input validation test passed: Correctly rejected null title");
                testsPassed++;
            }
        } catch (Exception e) {
            System.out.println("✗ Input validation test failed: " + e.getMessage());
        }
        totalTests++;
    }
}
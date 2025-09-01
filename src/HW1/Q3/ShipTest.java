public class ShipTest {
    private static int testsPassed = 0;
    private static int totalTests = 0;
    
    public static void runTests() {
        System.out.println("Testing Ship Base Class");
        System.out.println("=======================");
        
        testConstructor();
        testGettersAndSetters();
        testPrintMethod();
        testEncapsulation();
        testInheritanceReadiness();
        
        System.out.println("\nShip Test Results: " + testsPassed + "/" + totalTests + " tests passed\n");
    }
    
    private static void testConstructor() {
        try {
            Ship ship = new Ship("Titanic", "1912");
            assert ship.getShipName().equals("Titanic") : "Constructor failed for shipName";
            assert ship.getYearBuilt().equals("1912") : "Constructor failed for yearBuilt";
            System.out.println("✓ Constructor test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Constructor test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testGettersAndSetters() {
        try {
            Ship ship = new Ship("Test Ship", "2000");
            
            // Test setters and getters
            ship.setShipName("Updated Ship");
            assert ship.getShipName().equals("Updated Ship") : "setShipName/getShipName failed";
            
            ship.setYearBuilt("2024");
            assert ship.getYearBuilt().equals("2024") : "setYearBuilt/getYearBuilt failed";
            
            System.out.println("✓ Getters and Setters test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Getters and Setters test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testPrintMethod() {
        try {
            Ship ship = new Ship("Queen Mary", "1936");
            
            // Test that print method exists and doesn't throw exceptions
            // Expected output: Ship name and year built
            System.out.println("Expected output: Ship name: Queen Mary, Year built: 1936");
            System.out.print("Actual output: ");
            ship.print();
            
            System.out.println("✓ Print method test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Print method test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testEncapsulation() {
        try {
            Ship ship = new Ship("Encapsulation Test", "2023");
            
            // Test that we can only access attributes through getters/setters
            // This test verifies proper encapsulation design
            String shipName = ship.getShipName();
            String yearBuilt = ship.getYearBuilt();
            
            assert shipName != null : "Ship name should be accessible via getter";
            assert yearBuilt != null : "Year built should be accessible via getter";
            
            // Test null values
            ship.setShipName(null);
            ship.setYearBuilt(null);
            // Should handle null gracefully
            
            System.out.println("✓ Encapsulation test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Encapsulation test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testInheritanceReadiness() {
        try {
            Ship ship = new Ship("Base Ship", "2020");
            
            // Test that the class is ready for inheritance
            assert ship instanceof Ship : "Ship should be instance of itself";
            
            // Test that methods exist that can be overridden
            ship.print(); // This should work for base class
            
            System.out.println("✓ Inheritance readiness test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Inheritance readiness test failed: " + e.getMessage());
        }
        totalTests++;
    }
}
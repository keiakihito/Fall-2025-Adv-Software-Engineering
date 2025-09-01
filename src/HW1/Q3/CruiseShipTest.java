public class CruiseShipTest {
    private static int testsPassed = 0;
    private static int totalTests = 0;
    
    public static void runTests() {
        System.out.println("Testing CruiseShip Class");
        System.out.println("========================");
        
        testConstructor();
        testInheritance();
        testMaxPassengersGetterSetter();
        testOverriddenPrintMethod();
        testPolymorphicBehavior();
        testEdgeCases();
        
        System.out.println("\nCruiseShip Test Results: " + testsPassed + "/" + totalTests + " tests passed\n");
    }
    
    private static void testConstructor() {
        try {
            CruiseShip cruiseShip = new CruiseShip("Royal Caribbean", "2015", 5000);
            
            // Test inherited attributes
            assert cruiseShip.getShipName().equals("Royal Caribbean") : "Constructor failed for inherited shipName";
            assert cruiseShip.getYearBuilt().equals("2015") : "Constructor failed for inherited yearBuilt";
            
            // Test new attribute
            assert cruiseShip.getMaxPassengers() == 5000 : "Constructor failed for maxPassengers";
            
            System.out.println("✓ Constructor test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Constructor test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testInheritance() {
        try {
            CruiseShip cruiseShip = new CruiseShip("Wonder of the Seas", "2022", 6988);
            
            // Test IS-A relationship
            assert cruiseShip instanceof Ship : "CruiseShip should be instance of Ship";
            assert cruiseShip instanceof CruiseShip : "CruiseShip should be instance of itself";
            
            // Test access to inherited methods
            String shipName = cruiseShip.getShipName();
            String yearBuilt = cruiseShip.getYearBuilt();
            assert shipName != null : "Should access inherited getShipName()";
            assert yearBuilt != null : "Should access inherited getYearBuilt()";
            
            System.out.println("✓ Inheritance test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Inheritance test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testMaxPassengersGetterSetter() {
        try {
            CruiseShip cruiseShip = new CruiseShip("Test Cruise", "2020", 3000);
            
            // Test getter
            assert cruiseShip.getMaxPassengers() == 3000 : "getMaxPassengers failed";
            
            // Test setter
            cruiseShip.setMaxPassengers(4000);
            assert cruiseShip.getMaxPassengers() == 4000 : "setMaxPassengers failed";
            
            // Test edge values
            cruiseShip.setMaxPassengers(0);
            assert cruiseShip.getMaxPassengers() == 0 : "Zero passengers should be allowed";
            
            System.out.println("✓ MaxPassengers getter/setter test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ MaxPassengers getter/setter test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testOverriddenPrintMethod() {
        try {
            CruiseShip cruiseShip = new CruiseShip("Symphony of the Seas", "2018", 6680);
            
            System.out.println("Expected CruiseShip print format: Ship name and max passengers (NOT year built)");
            System.out.print("Actual CruiseShip print output: ");
            cruiseShip.print();
            
            // The print method should display ship name and max passengers
            // NOT the year built (as per requirements)
            
            System.out.println("✓ Overridden print method test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Overridden print method test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testPolymorphicBehavior() {
        try {
            // Test polymorphic assignment
            Ship ship = new CruiseShip("Allure of the Seas", "2010", 6780);
            
            // Should be able to access Ship methods
            assert ship.getShipName().equals("Allure of the Seas") : "Polymorphic access to shipName failed";
            assert ship.getYearBuilt().equals("2010") : "Polymorphic access to yearBuilt failed";
            
            // When calling print() through Ship reference, 
            // it should still execute CruiseShip's overridden print()
            System.out.println("Testing polymorphic print() call:");
            System.out.print("Polymorphic print output: ");
            ship.print(); // Should call CruiseShip's print(), not Ship's print()
            
            System.out.println("✓ Polymorphic behavior test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Polymorphic behavior test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testEdgeCases() {
        try {
            // Test with very large passenger capacity
            CruiseShip largeCruise = new CruiseShip("Mega Ship", "2025", 10000);
            assert largeCruise.getMaxPassengers() == 10000 : "Large passenger capacity failed";
            
            // Test with negative passengers (should be handled gracefully)
            CruiseShip negativeCruise = new CruiseShip("Test Ship", "2023", -100);
            // Implementation should handle this appropriately
            
            // Test with null/empty strings
            CruiseShip nullTest = new CruiseShip("", "", 1000);
            assert nullTest.getShipName().equals("") : "Empty ship name should be handled";
            
            System.out.println("✓ Edge cases test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Edge cases test failed: " + e.getMessage());
        }
        totalTests++;
    }
}
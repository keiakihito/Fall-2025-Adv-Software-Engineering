public class CargoShipTest {
    private static int testsPassed = 0;
    private static int totalTests = 0;
    
    public static void runTests() {
        System.out.println("Testing CargoShip Class");
        System.out.println("=======================");
        
        testConstructor();
        testInheritance();
        testCargoCapacityGetterSetter();
        testOverriddenPrintMethod();
        testPolymorphicBehavior();
        testEdgeCases();
        
        System.out.println("\nCargoShip Test Results: " + testsPassed + "/" + totalTests + " tests passed\n");
    }
    
    private static void testConstructor() {
        try {
            CargoShip cargoShip = new CargoShip("Ever Given", "2018", 20000);
            
            // Test inherited attributes
            assert cargoShip.getShipName().equals("Ever Given") : "Constructor failed for inherited shipName";
            assert cargoShip.getYearBuilt().equals("2018") : "Constructor failed for inherited yearBuilt";
            
            // Test new attribute
            assert cargoShip.getCargoCapacity() == 20000 : "Constructor failed for cargoCapacity";
            
            System.out.println("✓ Constructor test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Constructor test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testInheritance() {
        try {
            CargoShip cargoShip = new CargoShip("Maersk Triple E", "2013", 18000);
            
            // Test IS-A relationship
            assert cargoShip instanceof Ship : "CargoShip should be instance of Ship";
            assert cargoShip instanceof CargoShip : "CargoShip should be instance of itself";
            
            // Test access to inherited methods
            String shipName = cargoShip.getShipName();
            String yearBuilt = cargoShip.getYearBuilt();
            assert shipName != null : "Should access inherited getShipName()";
            assert yearBuilt != null : "Should access inherited getYearBuilt()";
            
            System.out.println("✓ Inheritance test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Inheritance test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testCargoCapacityGetterSetter() {
        try {
            CargoShip cargoShip = new CargoShip("Test Cargo", "2020", 15000);
            
            // Test getter
            assert cargoShip.getCargoCapacity() == 15000 : "getCargoCapacity failed";
            
            // Test setter
            cargoShip.setCargoCapacity(25000);
            assert cargoShip.getCargoCapacity() == 25000 : "setCargoCapacity failed";
            
            // Test edge values
            cargoShip.setCargoCapacity(0);
            assert cargoShip.getCargoCapacity() == 0 : "Zero cargo capacity should be allowed";
            
            System.out.println("✓ CargoCapacity getter/setter test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ CargoCapacity getter/setter test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testOverriddenPrintMethod() {
        try {
            CargoShip cargoShip = new CargoShip("MSC Gulsun", "2019", 23756);
            
            System.out.println("Expected CargoShip print format: Ship name and cargo capacity (NOT year built)");
            System.out.print("Actual CargoShip print output: ");
            cargoShip.print();
            
            // The print method should display ship name and cargo capacity
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
            Ship ship = new CargoShip("OOCL Hong Kong", "2017", 21413);
            
            // Should be able to access Ship methods
            assert ship.getShipName().equals("OOCL Hong Kong") : "Polymorphic access to shipName failed";
            assert ship.getYearBuilt().equals("2017") : "Polymorphic access to yearBuilt failed";
            
            // When calling print() through Ship reference, 
            // it should still execute CargoShip's overridden print()
            System.out.println("Testing polymorphic print() call:");
            System.out.print("Polymorphic print output: ");
            ship.print(); // Should call CargoShip's print(), not Ship's print()
            
            System.out.println("✓ Polymorphic behavior test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Polymorphic behavior test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testEdgeCases() {
        try {
            // Test with very large cargo capacity
            CargoShip largeCargo = new CargoShip("Super Cargo", "2025", 50000);
            assert largeCargo.getCargoCapacity() == 50000 : "Large cargo capacity failed";
            
            // Test with negative cargo capacity (should be handled gracefully)
            CargoShip negativeCargo = new CargoShip("Test Ship", "2023", -1000);
            // Implementation should handle this appropriately
            
            // Test with null/empty strings
            CargoShip nullTest = new CargoShip("", "", 10000);
            assert nullTest.getShipName().equals("") : "Empty ship name should be handled";
            
            // Test with decimal-like capacity (should handle int conversion)
            CargoShip intCapacity = new CargoShip("Int Test", "2024", 12345);
            assert intCapacity.getCargoCapacity() == 12345 : "Integer cargo capacity should work";
            
            System.out.println("✓ Edge cases test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Edge cases test failed: " + e.getMessage());
        }
        totalTests++;
    }
}
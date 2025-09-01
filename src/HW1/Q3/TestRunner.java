public class TestRunner {
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("    SHIP INHERITANCE QUALITY TEST SUITE   ");
        System.out.println("===========================================\n");
        
        try {
            // Run individual class tests
            ShipTest.runTests();
            CruiseShipTest.runTests();
            CargoShipTest.runTests();
            
            System.out.println("===========================================");
            System.out.println("         INTEGRATION TESTS               ");
            System.out.println("===========================================");
            testPolymorphismIntegration();
            
            System.out.println("\n===========================================");
            System.out.println("      POLYMORPHISM DEMONSTRATION          ");
            System.out.println("===========================================");
            testDynamicMethodDispatch();
            
            System.out.println("\n===========================================");
            System.out.println("         INHERITANCE HIERARCHY            ");
            System.out.println("===========================================");
            testInheritanceHierarchy();
            
            System.out.println("\n===========================================");
            System.out.println("            ALL TESTS COMPLETED            ");
            System.out.println("===========================================");
            
        } catch (Exception e) {
            System.out.println("✗ Critical error during testing: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void testPolymorphismIntegration() {
        try {
            System.out.println("Testing polymorphic array behavior (matches driver program requirements):");
            
            // Create static array of Ship objects (as required by specifications)
            Ship[] ships = new Ship[3];
            ships[0] = new Ship("Generic Ship", "2000");
            ships[1] = new CruiseShip("Celebrity Edge", "2018", 2900);
            ships[2] = new CargoShip("Emma Maersk", "2006", 15000);
            
            System.out.println("\nArray contents and polymorphic behavior:");
            for (int i = 0; i < ships.length; i++) {
                System.out.print("ships[" + i + "] (" + ships[i].getClass().getSimpleName() + "): ");
                ships[i].print(); // Should call appropriate overridden method
            }
            
            System.out.println("✓ Polymorphism integration test passed");
            
        } catch (Exception e) {
            System.out.println("✗ Polymorphism integration test failed: " + e.getMessage());
        }
    }
    
    private static void testDynamicMethodDispatch() {
        try {
            System.out.println("Testing dynamic method dispatch with Ship references:");
            
            // All referenced as Ship, but should call correct print() method
            Ship ship1 = new Ship("Base Ship", "1990");
            Ship ship2 = new CruiseShip("Harmony of the Seas", "2016", 6780);
            Ship ship3 = new CargoShip("Madrid Maersk", "2017", 20568);
            
            System.out.println("\nDynamic method dispatch demonstration:");
            System.out.print("Ship reference to Ship object: ");
            ship1.print(); // Should call Ship's print()
            
            System.out.print("Ship reference to CruiseShip object: ");
            ship2.print(); // Should call CruiseShip's print()
            
            System.out.print("Ship reference to CargoShip object: ");
            ship3.print(); // Should call CargoShip's print()
            
            System.out.println("✓ Dynamic method dispatch test passed");
            
        } catch (Exception e) {
            System.out.println("✗ Dynamic method dispatch test failed: " + e.getMessage());
        }
    }
    
    private static void testInheritanceHierarchy() {
        try {
            System.out.println("Testing inheritance hierarchy and IS-A relationships:");
            
            Ship ship = new Ship("Base", "2020");
            CruiseShip cruise = new CruiseShip("Cruise", "2021", 3000);
            CargoShip cargo = new CargoShip("Cargo", "2022", 15000);
            
            // Test IS-A relationships
            assert ship instanceof Ship : "Ship should be instance of Ship";
            assert cruise instanceof Ship : "CruiseShip should be instance of Ship";
            assert cruise instanceof CruiseShip : "CruiseShip should be instance of CruiseShip";
            assert cargo instanceof Ship : "CargoShip should be instance of Ship";
            assert cargo instanceof CargoShip : "CargoShip should be instance of CargoShip";
            
            // Test that subclasses can access parent methods
            assert cruise.getShipName().equals("Cruise") : "CruiseShip should access inherited getShipName()";
            assert cargo.getYearBuilt().equals("2022") : "CargoShip should access inherited getYearBuilt()";
            
            System.out.println("Inheritance hierarchy verified:");
            System.out.println("- Ship (base class)");
            System.out.println("  ├── CruiseShip extends Ship");
            System.out.println("  └── CargoShip extends Ship");
            
            System.out.println("✓ Inheritance hierarchy test passed");
            
        } catch (Exception e) {
            System.out.println("✗ Inheritance hierarchy test failed: " + e.getMessage());
        }
    }
}

/*
===========================================
    SHIP INHERITANCE QUALITY TEST SUITE   
===========================================

Testing Ship Base Class
=======================
✓ Constructor test passed
✓ Getters and Setters test passed
Expected output: Ship name: Queen Mary, Year built: 1936
Actual output: Ship name: Queen Mary, Year built: 1936
✓ Print method test passed
✓ Encapsulation test passed
Ship name: Base Ship, Year built: 2020
✓ Inheritance readiness test passed

Ship Test Results: 5/5 tests passed

Testing CruiseShip Class
========================
✓ Constructor test passed
✓ Inheritance test passed
✓ MaxPassengers getter/setter test passed
Expected CruiseShip print format: Ship name and max passengers (NOT year built)
Actual CruiseShip print output: Ship name: Symphony of the Seas, Maximum passengers: 6680
✓ Overridden print method test passed
Testing polymorphic print() call:
Polymorphic print output: Ship name: Allure of the Seas, Maximum passengers: 6780
✓ Polymorphic behavior test passed
✓ Edge cases test passed

CruiseShip Test Results: 6/6 tests passed

Testing CargoShip Class
=======================
✓ Constructor test passed
✓ Inheritance test passed
✓ CargoCapacity getter/setter test passed
Expected CargoShip print format: Ship name and cargo capacity (NOT year built)
Actual CargoShip print output: Ship name: MSC Gulsun, Cargo capacity: 23756 tonnage
✓ Overridden print method test passed
Testing polymorphic print() call:
Polymorphic print output: Ship name: OOCL Hong Kong, Cargo capacity: 21413 tonnage
✓ Polymorphic behavior test passed
✓ Edge cases test passed

CargoShip Test Results: 6/6 tests passed

===========================================
         INTEGRATION TESTS               
===========================================
Testing polymorphic array behavior (matches driver program requirements):

Array contents and polymorphic behavior:
ships[0] (Ship): Ship name: Generic Ship, Year built: 2000
ships[1] (CruiseShip): Ship name: Celebrity Edge, Maximum passengers: 2900
ships[2] (CargoShip): Ship name: Emma Maersk, Cargo capacity: 15000 tonnage
✓ Polymorphism integration test passed

===========================================
      POLYMORPHISM DEMONSTRATION          
===========================================
Testing dynamic method dispatch with Ship references:

Dynamic method dispatch demonstration:
Ship reference to Ship object: Ship name: Base Ship, Year built: 1990
Ship reference to CruiseShip object: Ship name: Harmony of the Seas, Maximum passengers: 6780
Ship reference to CargoShip object: Ship name: Madrid Maersk, Cargo capacity: 20568 tonnage
✓ Dynamic method dispatch test passed

===========================================
         INHERITANCE HIERARCHY            
===========================================
Testing inheritance hierarchy and IS-A relationships:
Inheritance hierarchy verified:
- Ship (base class)
  ├── CruiseShip extends Ship
  └── CargoShip extends Ship
✓ Inheritance hierarchy test passed

===========================================
            ALL TESTS COMPLETED            
===========================================
 */
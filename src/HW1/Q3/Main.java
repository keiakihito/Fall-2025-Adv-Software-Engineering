/**
 * Main driver program demonstrating ship inheritance and polymorphism.
 * This program creates a static array of Ship objects containing different ship types
 * and demonstrates polymorphic behavior through method overriding and dynamic dispatch.
 * 
 * The program showcases:
 * - Inheritance hierarchy (Ship -> CruiseShip, CargoShip)
 * - Polymorphism through overridden print() methods
 * - Dynamic method dispatch at runtime
 * - Encapsulation with private attributes
 * 
 * @author kkatsumi
 * @version 1.0
 * @since 2025
 */
public class Main {
    
    /**
     * Main method that demonstrates ship inheritance and polymorphism.
     * Creates a static array of Ship objects, populates it with different ship types,
     * and uses a loop to call print() on each object, demonstrating dynamic method dispatch.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println("       Adv. Software Engineering Fall 2025 - HW1: Ship Inheritance         ");
        System.out.println("===============================================\n");
        
        // 1. Create a static array of Ship objects of size 3
        Ship[] ships = new Ship[3];
        
        // 2. Populate the array with one Ship, one CruiseShip, and one CargoShip
        ships[0] = new Ship("Titanic", "1912");
        ships[1] = new CruiseShip("Royal Caribbean", "2020", 5000);
        ships[2] = new CargoShip("Ever Given", "2018", 20000);
        
        System.out.println("POLYMORPHISM DEMONSTRATION");
        System.out.println("===========================");
        System.out.println("Static array contains different ship types, all referenced as Ship objects:");
        
        // 3. Use a loop to iterate through the array and call print() on each object
        for (int i = 0; i < ships.length; i++) {
            System.out.printf("ships[%d] (%s): ", i, ships[i].getClass().getSimpleName());
            ships[i].print(); // Demonstrates polymorphism - correct overridden print() is executed
        }
        
        System.out.println("\nDYNAMIC METHOD DISPATCH EXPLANATION");
        System.out.println("====================================");
        System.out.println("Even though all objects are referenced as 'Ship' in the array:");
        System.out.println("- ships[0].print() calls Ship's print() method (shows name and year)");
        System.out.println("- ships[1].print() calls CruiseShip's print() method (shows name and passengers)");
        System.out.println("- ships[2].print() calls CargoShip's print() method (shows name and cargo capacity)");
        System.out.println("\nThis demonstrates POLYMORPHISM through dynamic method dispatch!");
        
        System.out.println("\nADDITIONAL DEMONSTRATIONS");
        System.out.println("=========================");
        
        // Demonstrate inheritance - subclasses can access parent methods
        System.out.println("Inheritance demonstration:");
        CruiseShip cruise = (CruiseShip) ships[1];
        System.out.printf("CruiseShip accessing inherited method: %s built in %s\n", 
                         cruise.getShipName(), cruise.getYearBuilt());
        System.out.printf("CruiseShip specific method: %d maximum passengers\n", 
                         cruise.getMaxPassengers());
        
        CargoShip cargo = (CargoShip) ships[2];
        System.out.printf("CargoShip accessing inherited method: %s built in %s\n", 
                         cargo.getShipName(), cargo.getYearBuilt());
        System.out.printf("CargoShip specific method: %d tonnage cargo capacity\n", 
                         cargo.getCargoCapacity());
    }
}

/*
 ===============================================
       Adv. Software Engineering Fall 2025 - HW1: Ship Inheritance         
===============================================

POLYMORPHISM DEMONSTRATION
===========================
Static array contains different ship types, all referenced as Ship objects:
ships[0] (Ship): Ship name: Titanic, Year built: 1912
ships[1] (CruiseShip): Ship name: Royal Caribbean, Maximum passengers: 5000
ships[2] (CargoShip): Ship name: Ever Given, Cargo capacity: 20000 tonnage

DYNAMIC METHOD DISPATCH EXPLANATION
====================================
Even though all objects are referenced as 'Ship' in the array:
- ships[0].print() calls Ship's print() method (shows name and year)
- ships[1].print() calls CruiseShip's print() method (shows name and passengers)
- ships[2].print() calls CargoShip's print() method (shows name and cargo capacity)

This demonstrates POLYMORPHISM through dynamic method dispatch!

ADDITIONAL DEMONSTRATIONS
=========================
Inheritance demonstration:
CruiseShip accessing inherited method: Royal Caribbean built in 2020
CruiseShip specific method: 5000 maximum passengers
CargoShip accessing inherited method: Ever Given built in 2018
CargoShip specific method: 20000 tonnage cargo capacity
 */
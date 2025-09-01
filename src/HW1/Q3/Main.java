public class Main {
    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println("       CS5800 - HW1: Ship Inheritance         ");
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
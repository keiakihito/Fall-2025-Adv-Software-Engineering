/**
 * Minimal driver program that strictly follows the assignment requirements.
 * This program demonstrates the basic requirements for ship inheritance:
 * 1. Creates a static array of Ship objects of size 3
 * 2. Populates with one Ship, one CruiseShip, one CargoShip
 * 3. Uses a loop to call print() on each object (demonstrates polymorphism)
 * 
 * @author kkatsumi
 * @version 1.0
 * @since 2025
 */
public class SimpleMain {
    
    /**
     * Main method that demonstrates basic ship inheritance and polymorphism.
     * Follows the exact requirements without additional explanations or formatting.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // 1. Create a static array of Ship objects of size 3
        Ship[] ships = new Ship[3];
        
        // 2. Populate the array with one Ship, one CruiseShip, and one CargoShip
        ships[0] = new Ship("Titanic", "1912");
        ships[1] = new CruiseShip("Royal Caribbean", "2020", 5000);
        ships[2] = new CargoShip("Ever Given", "2018", 20000);
        
        // 3. Use a loop to iterate through the array and call print() on each object
        for (int i = 0; i < ships.length; i++) {
            ships[i].print();
        }
    }
}
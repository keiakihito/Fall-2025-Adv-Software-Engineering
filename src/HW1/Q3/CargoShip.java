/**
 * Represents a cargo ship designed to transport goods and freight.
 * This class extends the Ship base class and adds cargo capacity functionality.
 * The print() method is overridden to display cargo capacity instead of year built.
 * 
 * @author CS5800 Student
 * @version 1.0
 * @since 2025
 */
public class CargoShip extends Ship {
    /** The cargo capacity of this ship in tonnage */
    private int cargoCapacity;
    
    /**
     * Constructs a CargoShip with the specified name, year built, and cargo capacity.
     * 
     * @param shipName the name of the cargo ship
     * @param yearBuilt the year the ship was built
     * @param cargoCapacity the cargo capacity in tonnage
     */
    public CargoShip(String shipName, String yearBuilt, int cargoCapacity) {
        super(shipName, yearBuilt);
        this.cargoCapacity = cargoCapacity;
    }
    
    /**
     * Returns the cargo capacity of this ship in tonnage.
     * 
     * @return the cargo capacity in tonnage
     */
    public int getCargoCapacity() {
        return cargoCapacity;
    }
    
    /**
     * Sets the cargo capacity of this ship in tonnage.
     * 
     * @param cargoCapacity the new cargo capacity in tonnage
     */
    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }
    
    /**
     * Prints the cargo ship's information including name and cargo capacity.
     * This method overrides the base Ship class print() method to show cargo
     * capacity instead of the year built, as specified in the requirements.
     * Output format: "Ship name: [name], Cargo capacity: [tonnage] tonnage"
     */
    @Override
    public void print() {
        System.out.printf("Ship name: %s, Cargo capacity: %d tonnage\n", getShipName(), cargoCapacity);
    }
}
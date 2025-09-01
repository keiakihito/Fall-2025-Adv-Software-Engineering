/**
 * Represents a generic ship with basic information.
 * This class serves as the base class for all ship types in the inheritance hierarchy,
 * providing common attributes and methods that can be inherited and overridden.
 * 
 * @author kkatsumi
 * @version 1.0
 * @since 2025
 */
public class Ship {
    /** The name of the ship */
    private String shipName;
    
    /** The year the ship was built */
    private String yearBuilt;
    
    /**
     * Constructs a Ship with the specified name and year built.
     * 
     * @param shipName the name of the ship
     * @param yearBuilt the year the ship was built
     */
    public Ship(String shipName, String yearBuilt) {
        this.shipName = shipName;
        this.yearBuilt = yearBuilt;
    }
    
    /**
     * Returns the name of the ship.
     * 
     * @return the ship's name
     */
    public String getShipName() {
        return shipName;
    }
    
    /**
     * Sets the name of the ship.
     * 
     * @param shipName the new ship name
     */
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
    
    /**
     * Returns the year the ship was built.
     * 
     * @return the year built as a String
     */
    public String getYearBuilt() {
        return yearBuilt;
    }
    
    /**
     * Sets the year the ship was built.
     * 
     * @param yearBuilt the new year built
     */
    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }
    
    /**
     * Prints the ship's information including name and year built.
     * This method can be overridden by subclasses to provide specific display formats.
     * Output format: "Ship name: [name], Year built: [year]"
     */
    public void print() {
        System.out.printf("Ship name: %s, Year built: %s\n", shipName, yearBuilt);
    }
}
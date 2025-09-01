/**
 * Represents a cruise ship designed to carry passengers for leisure travel.
 * This class extends the Ship base class and adds passenger capacity functionality.
 * The print() method is overridden to display passenger information instead of year built.
 * 
 * @author kkatsumi
 * @version 1.0
 * @since 2025
 */
public class CruiseShip extends Ship {
    /** The maximum number of passengers this cruise ship can carry */
    private int maxPassengers;
    
    /**
     * Constructs a CruiseShip with the specified name, year built, and passenger capacity.
     * 
     * @param shipName the name of the cruise ship
     * @param yearBuilt the year the ship was built
     * @param maxPassengers the maximum number of passengers
     */
    public CruiseShip(String shipName, String yearBuilt, int maxPassengers) {
        super(shipName, yearBuilt);
        this.maxPassengers = maxPassengers;
    }
    
    /**
     * Returns the maximum number of passengers this cruise ship can carry.
     * 
     * @return the maximum passenger capacity
     */
    public int getMaxPassengers() {
        return maxPassengers;
    }
    
    /**
     * Sets the maximum number of passengers this cruise ship can carry.
     * 
     * @param maxPassengers the new maximum passenger capacity
     */
    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }
    
    /**
     * Prints the cruise ship's information including name and maximum passengers.
     * This method overrides the base Ship class print() method to show passenger
     * capacity instead of the year built, as specified in the requirements.
     * Output format: "Ship name: [name], Maximum passengers: [number]"
     */
    @Override
    public void print() {
        System.out.printf("Ship name: %s, Maximum passengers: %d\n", getShipName(), maxPassengers);
    }
}
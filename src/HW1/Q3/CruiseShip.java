public class CruiseShip extends Ship {
    private int maxPassengers;
    
    public CruiseShip(String shipName, String yearBuilt, int maxPassengers) {
        super(shipName, yearBuilt);
        this.maxPassengers = maxPassengers;
    }
    
    public int getMaxPassengers() {
        return maxPassengers;
    }
    
    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }
    
    @Override
    public void print() {
        System.out.printf("Ship name: %s, Maximum passengers: %d\n", getShipName(), maxPassengers);
    }
}
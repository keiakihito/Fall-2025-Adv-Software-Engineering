public class Ship {
    private String shipName;
    private String yearBuilt;
    
    public Ship(String shipName, String yearBuilt) {
        this.shipName = shipName;
        this.yearBuilt = yearBuilt;
    }
    
    public String getShipName() {
        return shipName;
    }
    
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
    
    public String getYearBuilt() {
        return yearBuilt;
    }
    
    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }
    
    public void print() {
        System.out.printf("Ship name: %s, Year built: %s\n", shipName, yearBuilt);
    }
}
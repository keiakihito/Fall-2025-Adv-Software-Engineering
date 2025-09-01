public class CargoShip extends Ship {
    private int cargoCapacity;
    
    public CargoShip(String shipName, String yearBuilt, int cargoCapacity) {
        super(shipName, yearBuilt);
        this.cargoCapacity = cargoCapacity;
    }
    
    public int getCargoCapacity() {
        return cargoCapacity;
    }
    
    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }
    
    @Override
    public void print() {
        System.out.printf("Ship name: %s, Cargo capacity: %d tonnage\n", getShipName(), cargoCapacity);
    }
}
import java.awt.*;
import java.util.ArrayList;
import java.util.IllegalFormatFlagsException;


public class CarTransport extends Truck implements Rampable {
    public CarTransport(int nrDoors, Color color, double enginePower, int weight, int maxCars, int x, int y) {

        //settar bilen y-värden bangar hårdkodningen

        setNrDoors(nrDoors);
        setColor(color);
        setEnginePower(enginePower);
        setWeight(weight);
        setModelName("CarTransport");
        setX(x);
        setY(y);
        this.maxCars = maxCars;
        setRampUp();


    }
    private Integer maxCars;


    private Boolean rampUp;

    /** Gör en lista med lastade bilar som bara får vara ett objekt av typen "Car"
     *
     */
    private ArrayList<Vehicle> loadedcars = new ArrayList<>(); //? extends Vehicle kanske

    /** Metod för att hämta hur många bilar som är lastade
     *
     * @return antalet lastade bilar
     */
    public Integer getNrLoadedCars() {
        return loadedcars.size();
    }


    public Boolean getRampUp() {
        return rampUp;
    }

    public void setRampUp() {
        rampUp=true;
    }




    public void setRampDown() {
        rampUp=false;
    }
    public void addLoadedCars(Vehicle vehicle){
        setRampDown();
        if(Math.abs(getX()-vehicle.getX())<=3 && Math.abs(getY()-vehicle.getY())<=3) {//bilen rimligt nära biltransporten
            if(vehicle.getWeight()<=3000 && loadedcars.size() < maxCars) { //kanske vi ska hitta ett sätt att inte ladda på en cartransport på en cartransport
                if(!loadedcars.contains(vehicle) && getRampUp()==false && !vehicle.isLoaded()) {//men problemet är då att då kan vi inte lasta på någon långtradare
                    //rampen måste vara nere

                    loadedcars.add(vehicle);
                    vehicle.setLoaded(true);
                    vehicle.setX(this.getX());
                    vehicle.setY(this.getY());
                }
                else {
                    throw new IllegalArgumentException("The car you're trying to load is already loaded");
                }
            }
            else{
                throw new IllegalFormatFlagsException("Make sure you are not loading a truck and check that the transport isn't full");
            }
        }
        else{
            throw new IllegalArgumentException("Make sure you are nearby the car you're trying to load");
        }
    }
    public void removeFromloadedcars(){
        if(getAngleTrBed() == 70) {
            if(loadedcars.size()>0){
                Vehicle furthestOutCar = loadedcars.get(loadedcars.size()-1);
                furthestOutCar.setX(this.getX()+loadedcars.size()-1);
                loadedcars.remove(loadedcars.size()-1);
                furthestOutCar.setLoaded(false);
            }
        }
    }

    /** Vill alltid lasta av bilen längst ut vid avlastning
     */

    public void lastaAvAllaBilar(){
        for (int i = loadedcars.size()-1; i >-1; i-- ){
            removeFromloadedcars();
        }
    }

    @Override
    public void move(){
        super.move();

        for(Vehicle vehicle : loadedcars){
            vehicle.setX(this.getX());
            vehicle.setY(this.getY());
        }
    }
}

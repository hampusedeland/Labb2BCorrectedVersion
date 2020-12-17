import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class CarModel {

    int widthRestriction;
    int heightRestriction;
    public CarModel(int widthRestriction,int heightRestriction){
        this.widthRestriction=widthRestriction; // Vehicles don't leave the 
        this.heightRestriction=heightRestriction;

    }


    public ArrayList<Vehicle> getCars() {
        return cars;
    }

    ArrayList<Vehicle> cars = new ArrayList<>();

    void move(){
        checkingCarsStayInWindow();
        for(Vehicle car : cars){
            car.move();
        }
    }


    // Göra så storlek beror av modellstorleken. Alltså X och Y under, kanske passa genom controller till vyn.


    void checkingCarsStayInWindow(){//just nu en manuell metod, alltså hur stort fönstret är får vi ange här
        for (Vehicle car : cars) {
            if (car.getX() >= widthRestriction-140 && car.getCurrentDirection().contains("east")) { //den hårdkodade biten är för bildernas bredd.
                car.turnLeft();
                car.turnLeft();
            } else if (car.getX() < 0 && car.getCurrentDirection().contains("west")) {
                car.turnLeft();
                car.turnLeft();
            } else if (car.getY() < 0 && car.getCurrentDirection().contains("south")) {
                car.turnLeft();
                car.turnLeft();
            } else if (car.getY() >= heightRestriction-140 && car.getCurrentDirection().contains("north")) {
                car.turnLeft();
                car.turnLeft();
            }
        }
    }




    void gas(int amount){
        double gas = ((double) amount) / 100;
        for(Vehicle car : cars){
            car.gas(gas);
        }
    }
    void brake(int amount){
        double brake = ((double) amount) / 100;
        for(Vehicle car: cars){
            car.brake(brake);
        }
    }

    void setTurboOn(){
        for(Vehicle car : cars){
            if (car.hasTurbo()) {
                ((Turboable) car).setTurboOn();
            }
        }
    }
    void setTurboOff(){
        for(Vehicle car : cars){
            if (car.hasTurbo()) {
                ((Turboable) car).setTurboOff();
            }
        }
    }
    void startCars(){
        for(Vehicle car: cars){
            car.startEngine();
        }
    }

    void stopCars(){
        for(Vehicle car: cars){
            car.stopEngine();
        }
    }
    void removeCar(){
        if(cars.size()>0){
            cars.remove(cars.size()-1);
        }
        else{
            System.out.println("There are no cars to remove!");
        }
    }
    void createVechicle(){
        //int i = (int) Math.floor((Math.random()*2));
        if(cars.size()<=10) {
            int randomnumber = ThreadLocalRandom.current().nextInt(0, 3);
            if (randomnumber == 0) {
                createSaabs();
            }
            if (randomnumber == 1) {
                createVolvos();
            }
            if (randomnumber == 2) {
                createScanias();
            }
        }
        else{
            System.out.println("The roads are full, max limit 10 cars");
        }
    }

    void createSaabs(){
        if(cars.size()<=10) {
            Saab95 saabis = Saab95.createSaab95();
            saabis.setCurrentDirection("east");
            saabis.setY(100);
            cars.add(saabis);
        }
        else{
            System.out.println("The roads are full, max limit 10 cars");
        }
    }

    void createScanias(){
        if(cars.size()<=10) {
            Scania scania = Scania.createScania();
            scania.setCurrentDirection("east");
            scania.setY(500);
            cars.add(scania);
        }
        else{
            System.out.println("The roads are full, max limit 10 cars");
        }
    }


    void createVolvos(){
        if(cars.size()<=10) {
            Volvo240 volvo240 = Volvo240.createVolvo240();
            volvo240.setCurrentDirection("east");
            volvo240.setY(300);
            cars.add(volvo240);
        }
        else{
            System.out.println("The roads are full, max limit 10 cars");
        }
    }
    void liftBed(){
        for(Vehicle car : cars){
            if(car.getHasLift()){
                if(car.getCurrentSpeed()==0) {
                    System.out.println("Weee raising my truck bed");
                    ((Liftable) car).setAngleTrBed(70);
                }
                else{
                    System.out.println("The car must stop, If you want to raise the truck bed");
                }

            }
        }
    }
    void setBedDown(){
        for(Vehicle car : cars){
            if(car.getHasLift()){
                ((Liftable) car).setAngleTrBed(0);
                System.out.println("MY truck bed is down");
            }
        }
    }


    String speedometer(){
        String allTheSpeeds= "<html> The cars on the screen have the following speed:";

        for(Vehicle car : cars){
            allTheSpeeds= allTheSpeeds + "<br/>" + car.getModelName() + " is moving at: " + car.getCurrentSpeed();
        }
        allTheSpeeds = allTheSpeeds + "<html>";

        return allTheSpeeds;
    }


}








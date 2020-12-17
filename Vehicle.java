import java.awt.Color;
/* Det som inte är med från vår gamla Car-klass:
   private double x = 0;
   private double y = 0;
   private String currentpos; //gjorde till protected
   private Boolean hasTurbo;
   private Boolean hasLift;

   public boolean hasTurbo(){
       //return getHasTurbo();
       return this instanceof Turboable;
   }
   public Boolean getHasLift() {
       return this instanceof Liftable;
   }
*/
public abstract class Vehicle extends Location implements Movable {
    private int nrDoors;
    private double enginePower;
    private int weight;
    private Color color;
    private String modelName;
    private double currentSpeed;
    private boolean isLoaded;
    private Boolean hasTurbo;
    private Boolean hasLift;

    public boolean hasTurbo(){
        //return getHasTurbo();
        return this instanceof Turboable;
    }
    public Boolean getHasLift() {
        return this instanceof Liftable;
    }

    public int getNrDoors() { return nrDoors; }
    public void setNrDoors(int nrDoors) { this.nrDoors = nrDoors; }

    public void setEnginePower(double enginePower) {
        if(enginePower>=0) {
            this.enginePower = enginePower;
        }
    }
    public double getEnginePower() { return enginePower; }


    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }

    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }

    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }

    public double getCurrentSpeed() { return currentSpeed; }
    public void setCurrentSpeed(double currentSpeed) {
        if(currentSpeed<0) {
            throw new IllegalArgumentException("Currentspeed must be non negative (was:"+ currentSpeed + ")");
        }
        this.currentSpeed = currentSpeed;
        //throw new exception
    }

    public boolean isLoaded() { return isLoaded; }
    public void setLoaded(boolean loaded) { isLoaded = loaded; }

    public void startEngine(){ currentSpeed = 0.1; }
    public void stopEngine(){ currentSpeed = 0; }

    public double speedFactor(){ return getEnginePower()*0.005; } //JIdder här, scanians hastighet

    public void incrementSpeed(double amount){
        if(getCurrentSpeed()>=0 && getCurrentSpeed()+ amount<=getEnginePower()) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        }
    }
    public void decrementSpeed(double amount){
        if(getCurrentSpeed() - amount >=0 && getCurrentSpeed() <=getEnginePower()) {
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        }
    }
    public void gas(double amount){
        if(amount<=1 && amount>=0){
            incrementSpeed(amount);
        }
    }
    public void brake(double amount){
        if(amount<=1 && amount>=0) {
            decrementSpeed(amount);

        }
    }
    /**
     *Om man är påväg norr så ökar Y med en positiv getCurrentSpeed så rör den sig i den positiv y-axelns riktning
     *Om man är påväg söder så ökar Y med en negativ getCurrentSpeed så rör den sig i den negativ y-axelns riktning
     *Om man är påväg söder så ökar X med en negativ getCurrentSpeed så rör den sig i den negativ x-axelns riktning
     *Om man är påväg norr så ökar X med en positiv getCurrentSpeed så rör den sig i den positiv x-axelns riktning
     */
    @Override
    public void move() {
        if(getCurrentDirection().equals("north")){
            setY(getY()+getCurrentSpeed());
        }
        if(getCurrentDirection().equals("south")){
            setY(getY()-getCurrentSpeed());
        }
        if(getCurrentDirection().equals("west")){
            setX(getX()-getCurrentSpeed());
        }
        if(getCurrentDirection().equals("east")){
            setX(getX()+getCurrentSpeed());
        }
    }
    /**
     *Om riktningen är norr så settar den riktningen åt väst för att få den att svänga vänster
     * osv....
     */
    @Override
    public void turnLeft() {
        if(getCurrentDirection().equals("north")){
            setCurrentDirection("west");
        }
        else if(getCurrentDirection().equals("west")){
            setCurrentDirection("south");
        }
        else if(getCurrentDirection().equals("south")){
            setCurrentDirection("east");
        }
        else if(getCurrentDirection().equals("east")){
            setCurrentDirection("north");
        }
    }
    /**
     * Om riktningen är norr så settar den riktningen åt öst för att få den att svänga höger
     */
    @Override
    public void turnRight() {
        if(getCurrentDirection().equals("north")){
            setCurrentDirection("east");
        }
        else if(getCurrentDirection().equals("east")){
            setCurrentDirection("south");
        }
        else if(getCurrentDirection().equals("south")){
            setCurrentDirection("west");
        }
        else if(getCurrentDirection().equals("west")){
            setCurrentDirection("north");
        }
    }
}


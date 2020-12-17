public abstract class Truck extends Vehicle implements Liftable { //implements Liftable
    private double angleTrBed = 0;

    public double getAngleTrBed() {
        return angleTrBed;
    }

    public void setAngleTrBed(double angleTrBed) {
        if(getAngleTrBed()>=0 && getAngleTrBed()<=70 && getCurrentSpeed()==0) { //maxvinkeln och om lastbilen är still
            this.angleTrBed = angleTrBed;
        }
        else {
            System.out.println("Make sure the Truck isn't moving, and the designated angle for the truck bed is between 0-70 degrees");
        }
    }

    @Override
    public void move() {
        if (angleTrBed == 0) {
            super.move();
        } else {
           System.out.println("For the truck to move, the truck bed must have a zero angle, the angle (was:" + getAngleTrBed() + ")");//getAngleTrBed()
        }
    }
}

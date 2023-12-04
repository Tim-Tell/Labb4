
import java.awt.*;

public class Scania extends Cars {

    private double trailerAngle;


    public Scania() {
        super(2, 400, Color.blue, "Scania",
                "North", 100, 0);
        trailerAngle = 0;
    }

    public double getTrailerAngle() {
        return trailerAngle;
    }


    public void trailerUp(double amount) {
        boolean b = this.getCurrentSpeed() != 0;
        if (b) {
            System.out.println("Can't move trailer when Truck is in moving");
        } else if (trailerAngle + amount > 70) {
            trailerAngle = 70;
        } else {
            trailerAngle = trailerAngle + amount;
        }

    }

    public void trailerDown(double amount) {
        boolean b = this.getCurrentSpeed() != 0;
        if (b) {
            System.out.println("Can't move trailer when Truck is in moving");
        } else if (trailerAngle - amount < 0) {
            trailerAngle = 0;
        } else {
            trailerAngle = trailerAngle - amount;
        }
    }

    public double speedFactor() {
        return 50;
    }

    @Override
    public void move(){
        if (trailerAngle > 0){
            System.out.println("Truck can't move while trailer is up");
        }
        else{
            super.move();
        }
    }

}
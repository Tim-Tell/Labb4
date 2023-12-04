
//import src.Cars;

import java.awt.*;

public class Volvo240 extends Cars {

    private final static double trimFactor = 1.25;


    public Volvo240() {
        super(4, 100, Color.black, "Volvo240", "North", 0, 0);
    }


    public double speedFactor() {

        return geteningePower() * 0.01 * trimFactor;

    }
}

//import src.Cars;

import java.awt.*;

public class Saab95 extends Cars {

    protected boolean turboOn;

    public Saab95(){
        super(2, 125, Color.red, "Saab95", "North", 200, 0);
        turboOn = false;
    }

    protected void setTurboOn(){
        turboOn = true;
    }

    protected void setTurboOff(){
        turboOn = false;
    }

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return geteningePower() * 0.01 * turbo;
    }

}
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class testCars {

    private Saab95 saab95;

    @Before
    public void init() {
        saab95 = new Saab95();
    }


    @Test
    public void testNrDoors() {
        assertTrue(saab95.GetnrDoors() == 2);
    }


    @Test
    public void testEnginePower() {
        assertTrue(saab95.getEnginePower() == 125);
    }

    @Test
    public void testCurrentSpeed() {
        assertTrue(saab95.GetcurrentSpeed() == 0);
        saab95.startEngine();
        assertTrue(saab95.GetcurrentSpeed() == 0.1);
    }

    @Test
    public void testColor() {
        assertTrue(saab95.getColor() == Color.red);
    }


    @Test
    public void testMove(){
        assertTrue(saab95.getPosX() == 0);
        assertTrue(saab95.getPosY() == 0);
        saab95.startEngine();
        saab95.move();
        assertTrue(saab95.getPosY() == 0.1);
    }

    @Test
    public void testTurnLeft(){
        assertTrue(saab95.getDirection() == "North");
        saab95.turnLeft();
        assertTrue(saab95.getDirection() == "West");
    }

    @Test
    public void testTurnRight() {
        assertTrue(saab95.getDirection() == "North");
        saab95.turnRight();
        assertTrue(saab95.getDirection() == "East");

    }

    @Test
    public void testGas() {
        //saab95.stopEngine();
        assertTrue(saab95.getCurrentSpeed() == 0);
        saab95.startEngine();
        assertTrue(saab95.getCurrentSpeed() == 0.1);
        saab95.gas(0.5);
        assertTrue(saab95.getCurrentSpeed() == 0.725);
        saab95.gas(5);
        assertTrue(saab95.getCurrentSpeed() == 0.725);

    }

    @Test
    public void testBrake(){
        saab95.startEngine();
        saab95.gas(0.5);
        saab95.brake(0.1);
        assertTrue(saab95.getCurrentSpeed() == 0.6);
        saab95.brake(1.0);
        assertTrue(saab95.getCurrentSpeed() == 0);


    }
}

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class testScania {

    private Scania scania;

    @Before
    public void init() {
        scania = new Scania();
    }

    @Test
    public void testTrailerUp(){
        scania.trailerUp(0);
        assertTrue(scania.getTrailerAngle() == 0);
        scania.trailerUp(30);
        assertTrue(scania.getTrailerAngle() == 30);
        scania.startEngine();
        scania.trailerUp(30);
        System.out.println(scania.getTrailerAngle());
        assertTrue(scania.getTrailerAngle() == 30);
        scania.stopEngine();
        scania.trailerUp(100);
        assertTrue(scania.getTrailerAngle() == 70);

    }

    @Test
    public void testTrailerDown(){
        scania.trailerDown(0);
        assertTrue(scania.getTrailerAngle() == 0);
        scania.trailerUp(30);
        assertTrue(scania.getTrailerAngle() == 30);
        scania.trailerDown(25);
        assertTrue(scania.getTrailerAngle() == 5);
        scania.startEngine();
        scania.trailerDown(3);
        assertTrue(scania.getTrailerAngle() == 5);
    }

    @Test
    public void testMove(){
        scania.trailerUp(30);
        scania.move();
        assertTrue(scania.getPosY() == 0);
        scania.trailerDown(30);
        scania.startEngine();
        scania.move();
        assertTrue(scania.getPosY()==0.1);
    }

}


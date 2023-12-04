import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class testCarTransport {

    private CarTransport carTransport;

    private CarTransport carTransport2;
    private Scania scania;

    private Volvo240 volvo;

    private Saab95 saab;

    @Before
    public void init(){
        carTransport = new CarTransport();
        scania = new Scania();
        volvo = new Volvo240();
        saab = new Saab95();
        carTransport2 = new CarTransport();
    }


    @Test
    public void testTrailerUp(){
        carTransport.startEngine();
        carTransport.trailerDown();
        assertTrue(carTransport.trailerUp == false);
        carTransport.stopEngine();
        carTransport.trailerUp();
        assertTrue(carTransport.trailerUp == true);
    }

    @Test
    public void testLoadCar(){
        carTransport.loadCar(scania);
        carTransport.loadCar(volvo);
        carTransport.trailerUp();
        carTransport.loadCar(saab);
        assertTrue(carTransport.carsOnTruck[2] == null);
        carTransport.trailerDown();
        carTransport.loadCar(saab);
        assertTrue(carTransport.carsOnTruck[0] == scania);
        assertTrue(carTransport.carsOnTruck[2] == saab);


    }
    @Test
    public void testUnloadCar(){
        carTransport.loadCar(scania);
        carTransport.loadCar(volvo);
        carTransport.unloadCar(scania);
        assertTrue(carTransport.carsOnTruck[0] == scania);
        assertTrue(carTransport.carsOnTruck[1] == volvo);
        carTransport.unloadCar(volvo);
        assertTrue(carTransport.carsOnTruck[1] == null);
    }

    @Test
    public void testLoadCarTransport(){
        carTransport.loadCar(carTransport2);
        assertTrue(carTransport.carsOnTruck[0]==null);
    }

    @Test
    public void testMove(){
        carTransport.loadCar(scania);
        carTransport.trailerUp();
        carTransport.startEngine();
        carTransport.move();
        assertTrue(carTransport.getPosY() == 0.1);
        assertTrue(scania.getPosY() == 0.1);
    }

}



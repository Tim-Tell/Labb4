import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class testCarShop {

    private CarShop<Volvo240> carShopVolvo;
    private CarShop<Cars> carShopCars;
    private Volvo240 volvo;

    private Saab95 saab;

    private Scania scania;

    private CarTransport carTransport;

    @Before
    public void init(){
        volvo = new Volvo240();
        saab = new Saab95();
        scania = new Scania();
        carTransport = new CarTransport();
        carShopVolvo = new CarShop<Volvo240>(3);
        carShopCars = new CarShop<Cars>(4);
    }

    @Test
    public void testLoadCarsInShop(){
        carShopVolvo.loadCarsInShop(volvo);
        assertTrue(carShopVolvo.carsInShop.get(0) == volvo);
        //carShopVolvo.loadCarsInShop(carTransport); //we want this to not be accepted, so yaay!
        //carShopVolvo.loadCarsInShop(scania); //we want this to not be accepted, so yaay!
        carShopCars.loadCarsInShop(carTransport);
        carShopCars.loadCarsInShop(scania);
        assertTrue(carShopCars.carsInShop.get(0) == carTransport);
        assertTrue(carShopCars.carsInShop.get(1) == scania);
        //carShopCars.loadCarsInShop(carShopVolvo); //we want this to not be accepted, so yaay!

    }
    @Test
    public void testUnloadCarsInShop() {
        carShopCars.loadCarsInShop(volvo);
        carShopCars.loadCarsInShop(saab);
        carShopCars.unloadCarsInShop(volvo);
        assertTrue(carShopCars.carsInShop.get(0) != volvo);
        assertTrue(carShopCars.carsInShop.get(0) == saab);
    }


}

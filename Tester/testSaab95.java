import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class testSaab95 {

    private Saab95 saab95;

    @Before
    public void init() {
        saab95 = new Saab95();
    }


    @Test
    public void testTurbo(){
        saab95.setTurboOn();
        assertTrue(saab95.turboOn == true);
        saab95.setTurboOff();
        assertTrue(saab95.turboOn == false);
    }

}

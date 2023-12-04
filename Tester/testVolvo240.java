import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class testVolvo240 {

    private Volvo240 volvo240;


    @Before
    public void init() {
        volvo240 = new Volvo240();
    }

    @Test
    public void testStartEngine() {
        volvo240.startEngine();
        assertTrue(volvo240.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testSpeedFactor() {
        double speedfactor = volvo240.speedFactor();
        assertTrue(speedfactor == 1.25);
    }
}

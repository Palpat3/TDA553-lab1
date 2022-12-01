package set;

import static org.junit.Assert.*;

import org.junit.Test;

public class TruckTest {
    @Test
    public void Truck_should_have_speed_factor(){
        Scania testScania = new Scania();

        assertTrue(testScania.speedFactor() == 0.9);
    }


}
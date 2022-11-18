package set;

import static org.junit.Assert.*;
import org.junit.Test;


public class Saab95Test{
    @Test
    public void Saab95_should_not_have_speed_above_enginePower(){
        Saab95 testCar = new Saab95();
        testCar.incrementSpeed(1000);
        assertTrue(testCar.getCurrentSpeed() == 125);
    }

    @Test
    public void Saab95_should_not_slow_down_and_get_negative_speed(){
        Saab95 testCar = new Saab95();
        testCar.decrementSpeed(1000);
        assertTrue(testCar.getCurrentSpeed() == 0);
    }


    @Test
    public void Saab95_should_be_able_to_turn_on_turbo(){
        Saab95 testCar = new Saab95();
        testCar.setTurboOn();
        assertTrue(testCar.isTurboOn());
    }

    @Test 
    public void Saab95_should_be_able_to_turn_off_turbo(){
        Saab95 testCar = new Saab95();
        testCar.setTurboOn();
        testCar.setTurboOff();
        assertFalse(testCar.isTurboOn());
    }
}
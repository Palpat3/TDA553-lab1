package set;

import static org.junit.Assert.*;
import org.junit.Test;


public class Saab95Test{
    @Test
    public void Saab95_should_not_have_speed_above_enginePower(){
        Saab95 testCar = new Saab95();
        testCar.setCurrentSpeed(125);
        testCar.gas(0.8);
        assertTrue(testCar.getCurrentSpeed() == 125);
    }

    @Test
    public void Saab95_should_not_slow_down_and_get_negative_speed(){
        Saab95 testCar = new Saab95();
        testCar.brake(0.8);
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

    @Test
    public void Saab95_should_be_subclass_of_Car_and_Vehicle(){
        Saab95 testCar = new Saab95();
        assertTrue(testCar instanceof Car);
        assertTrue(testCar instanceof Vehicle);
    }
}
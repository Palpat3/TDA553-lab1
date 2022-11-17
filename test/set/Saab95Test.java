package set;

import static org.junit.Assert.*;
import org.junit.Test;


public class Saab95Test{
    
    @Test
    public void Saab95_should_not_have_negative_speed(){
        Saab95 testCar = new Saab95();
        assertThrows(IllegalArgumentException.class, () ->{
            testCar.brake(0.8);
        });
    }

    @Test
    public void Saab95_should_move_correctly(){
        Saab95 testCar = new Saab95();
        testCar.setCurrentSpeed(10);
        testCar.move();
        assertTrue(testCar.getY() == 10);

    }

    @Test
    public void Saab95_should_not_have_speed_above_enginePower(){
        Saab95 testCar = new Saab95();
        testCar.setCurrentSpeed(150);
        assertTrue(testCar.getCurrentSpeed() < 125);
    }

}
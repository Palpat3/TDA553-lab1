package set;

import static org.junit.Assert.*;
import org.junit.Test;

public class CarTest{
    @Test
    public void Car_should_be_able_to_gas(){
        Saab95 testCar = new Saab95();
        testCar.gas(0.9);
        Volvo240 testCar2 = new Volvo240();
        testCar2.gas(0.9);
        assertTrue(testCar.getCurrentSpeed() == 125 * 0.01 * 0.9);
        assertTrue(testCar2.getCurrentSpeed() == 100 * 0.01 * 1.25 * 0.9);
    }

    @Test
    public void Car_should_be_able_to_brake(){
        Saab95 testCar = new Saab95();
        Volvo240 testCar2 = new Volvo240();
        testCar.gas(0.1);
        testCar.brake(0.1);
        testCar2.gas(0.1);
        testCar2.brake(0.1);
        assertTrue(testCar.getCurrentSpeed() == 0);
        assertTrue(testCar2.getCurrentSpeed() == 0);
    }
}
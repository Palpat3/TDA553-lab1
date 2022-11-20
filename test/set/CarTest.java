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
    
    @Test
    public void Car_setCurrentSpeed_should_stay_at_old_value_if_given_illegal_argument(){
        Saab95 testCar = new Saab95();
        Volvo240 testCar2 = new Volvo240();

        assertThrows(IllegalArgumentException.class, () ->{
            testCar.setCurrentSpeed(150);
        });
        assertThrows(IllegalArgumentException.class, () ->{
            testCar2.setCurrentSpeed(150);
        });
    }

    @Test 
    public void Car_should_not_gas_above_enginePower(){
        Volvo240 testCar = new Volvo240();
        Saab95 testCar2 = new Saab95();
        testCar.setCurrentSpeed(testCar.getEnginePower());
        testCar.gas(0.8);
        assertTrue(testCar.getCurrentSpeed() == testCar.getEnginePower());
        testCar2.setCurrentSpeed(testCar2.getEnginePower());
        testCar2.gas(0.8);
        assertTrue(testCar.getCurrentSpeed() == testCar.getEnginePower());
        
    }
    @Test 
    public void Car_should_not_brake_and_get_negative_speed(){
        Volvo240 testCar = new Volvo240();
        Saab95 testCar2 = new Saab95();
        testCar.brake(0.8);
        assertTrue(testCar.getCurrentSpeed() == 0);
        testCar2.brake(0.8);
        assertTrue(testCar2.getCurrentSpeed() == 0);
    }

    @Test
    public void Car_should_only_take_values_between_0_and_1_for_gas_and_brake(){
        Saab95 testCar = new Saab95();
        Volvo240 testCar2 = new Volvo240();

        assertThrows(IllegalArgumentException.class, () -> {
            testCar.brake(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            testCar.gas(2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            testCar.gas(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            testCar.brake(2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            testCar2.brake(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            testCar2.gas(2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            testCar2.gas(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            testCar2.brake(2);
        });

    }
}
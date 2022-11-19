package set;

import static org.junit.Assert.*;
import org.junit.Test;

public class Volvo240Test{
    @Test
    public void Volvo240_should_not_be_abstract(){
        Volvo240 testCar = new Volvo240();
        assertTrue(testCar instanceof Volvo240);
    
    }

    @Test
    public void Volvo240_should_be_subclass_of_Vehicle_and_Car(){
        Volvo240 testCar = new Volvo240();
        assertTrue(testCar instanceof Vehicle);
        assertTrue(testCar instanceof Car);
    }

    @Test
    public void Volvo240_should_move_correctly(){
        Volvo240 testCar = new Volvo240();
        testCar.setCurrentSpeed(10);
        testCar.move();
        testCar.setDir(1);
        testCar.move();
        assertTrue(testCar.getY() == 10);
        assertTrue(testCar.getX() == 10);
    }

    @Test 
    public void Volvo240_should_not_gas_above_enginePower(){
        Volvo240 testCar = new Volvo240();
        testCar.incrementSpeed(1000);
        assertTrue(testCar.getCurrentSpeed() == testCar.getEnginePower());
        
    }
    @Test 
    public void Volvo240_should_not_brake_and_get_negative_speed(){
        Volvo240 testCar = new Volvo240();
        testCar.decrementSpeed(1000);
        assertTrue(testCar.getCurrentSpeed() == 0);
    }



    

}
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
    public void Volvo240_should_not_gas_outside_given_span(){
        Volvo240 testCar = new Volvo240();
        assertThrows(IllegalArgumentException.class, () -> {
            testCar.gas(1.1);
        });
       
    }
    @Test 
    public void Volvo240_should_not_brake_outside_given_span(){
        Volvo240 testCar = new Volvo240();
        assertThrows(IllegalArgumentException.class, () -> {
            testCar.brake(1.1);
        });
    }


    

}
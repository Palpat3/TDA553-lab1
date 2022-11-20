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

    
}
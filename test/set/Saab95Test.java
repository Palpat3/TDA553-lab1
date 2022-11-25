package set;

import static org.junit.Assert.*;
import org.junit.Test;


public class Saab95Test{
    @Test
    public void Saab95_should_not_have_speed_above_enginePower(){
        Saab95 saab = new Saab95();

        saab.setCurrentSpeed(125);
        saab.gas(0.8);

        assertTrue(saab.getCurrentSpeed() == 125);
    }

    @Test
    public void Saab95_should_not_slow_down_and_get_negative_speed(){
        Saab95 saab = new Saab95();

        saab.brake(0.8);

        assertTrue(saab.getCurrentSpeed() == 0);
    }


    @Test
    public void Saab95_should_be_able_to_turn_on_turbo(){
        Saab95 saab = new Saab95();

        saab.setTurboOn();

        assertTrue(saab.isTurboOn());
    }

    @Test 
    public void Saab95_should_be_able_to_turn_off_turbo(){
        Saab95 saab = new Saab95();

        saab.setTurboOn();
        saab.setTurboOff();

        assertFalse(saab.isTurboOn());
    }

    @Test
    public void Saab95_should_be_subclass_of_Car_and_Vehicle(){
        Saab95 saab = new Saab95();
        
        assertTrue(saab instanceof Car);
        assertTrue(saab instanceof Vehicle);
    }
}
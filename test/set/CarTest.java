package set;

import static org.junit.Assert.*;
import org.junit.Test;

public class CarTest{
    @Test
    public void Car_should_be_able_to_gas(){
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        saab.gas(0.9);
        volvo.gas(0.9);

        assertTrue(saab.getCurrentSpeed() == 125 * 0.01 * 0.9);
        assertTrue(volvo.getCurrentSpeed() == 100 * 0.01 * 1.25 * 0.9);
    }

    @Test
    public void Car_should_be_able_to_brake(){
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        saab.gas(0.1);
        volvo.gas(0.1);

        saab.brake(0.1);
        volvo.brake(0.1);

        assertTrue(saab.getCurrentSpeed() == 0);
        assertTrue(volvo.getCurrentSpeed() == 0);
    }
    
    @Test
    public void Car_setCurrentSpeed_should_stay_at_old_value_if_given_illegal_argument(){
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        assertThrows(IllegalArgumentException.class, () ->{
            saab.setCurrentSpeed(150);
        });

        assertThrows(IllegalArgumentException.class, () ->{
            volvo.setCurrentSpeed(150);
        });
    }

    @Test 
    public void Car_should_not_gas_above_enginePower(){
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        
        saab.setCurrentSpeed(saab.getEnginePower());
        volvo.setCurrentSpeed(volvo.getEnginePower());

        saab.gas(0.8);
        volvo.gas(0.8);

        assertTrue(saab.getCurrentSpeed() == saab.getEnginePower());
        assertTrue(saab.getCurrentSpeed() == saab.getEnginePower());
        
    }
    @Test 
    public void Car_should_not_brake_and_get_negative_speed(){
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        saab.brake(0.8);
        volvo.brake(0.8);

        assertTrue(saab.getCurrentSpeed() == 0);
        assertTrue(volvo.getCurrentSpeed() == 0);
    }

    @Test
    public void Car_should_only_take_values_between_0_and_1_for_gas_and_brake(){
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        assertThrows(IllegalArgumentException.class, () -> {
            saab.brake(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            volvo.brake(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            saab.gas(2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            volvo.gas(2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            saab.gas(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            volvo.gas(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            saab.brake(2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            volvo.brake(2);
        });

    }
}
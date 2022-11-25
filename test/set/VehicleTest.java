package set;

import static org.junit.Assert.*;
import org.junit.Test;

public class VehicleTest{
    @Test
    public void Vehicle_should_be_able_to_turn_left(){
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        saab.turnLeft();
        volvo.turnLeft();

        assertTrue(saab.getDirection() == 3);
        assertTrue(volvo.getDirection() == 3);
    }

    @Test
    public void Vehicle_should_be_able_to_turn_right(){
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        saab.turnRight();
        volvo.turnRight();

        assertTrue(saab.getDirection() == 1);
        assertTrue(volvo.getDirection() == 1);
    }

    @Test
    public void Vehicle_should_be_able_to_move(){
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        saab.setCurrentSpeed(10);
        volvo.setCurrentSpeed(10);

        saab.move();
        volvo.move();

        assertTrue(saab.getY() == 10);
        assertTrue(volvo.getY() == 10);
    }

    @Test
    public void Vehicle_should_be_able_to_turn_on(){
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        saab.startVehicle();
        volvo.startVehicle();

        assertTrue(saab.getCurrentSpeed() == 0.1);
        assertTrue(volvo.getCurrentSpeed() == 0.1);
    }

    @Test
    public void Vehicle_should_be_able_to_turn_off(){
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        saab.stopVehicle();
        volvo.stopVehicle();

        assertTrue(saab.getCurrentSpeed() == 0);
        assertTrue(volvo.getCurrentSpeed() == 0);
    }
}
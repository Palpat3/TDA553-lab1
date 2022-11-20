package set;

import static org.junit.Assert.*;
import org.junit.Test;

public class VehicleTest{
    @Test
    public void Vehicle_should_be_able_to_turn_left(){
        Saab95 testVehicle = new Saab95();
        testVehicle.turnLeft();
        assertTrue(testVehicle.getDirection() == 3);
    }

    @Test
    public void Vehicle_should_be_able_to_turn_right(){
        Saab95 testVehicle = new Saab95();
        testVehicle.turnRight();
        assertTrue(testVehicle.getDirection() == 1);
    }

    @Test
    public void Vehicle_should_be_able_to_move(){
        Saab95 testVehicle = new Saab95();
        testVehicle.setCurrentSpeed(10);
        testVehicle.move();
        assertTrue(testVehicle.getY() == 10);
    }

    @Test
    public void Vehicle_should_be_able_to_turn_on(){
        Saab95 testVehicle = new Saab95();
        testVehicle.startVehicle();
        assertTrue(testVehicle.getCurrentSpeed() == 0.1);
    }

    @Test
    public void Vehicle_should_be_able_to_turn_off(){
        Saab95 testVehicle = new Saab95();
        testVehicle.startVehicle();
        testVehicle.stopVehicle();
        assertTrue(testVehicle.getCurrentSpeed() == 0);
    }
}
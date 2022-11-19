package set;

import static org.junit.Assert.*;
import org.junit.Test;

public class MovableTest{
    @Test
    public void Movable_should_be_implemented_in_vehicle(){
        Saab95 testVehicle = new Saab95();
        testVehicle.setCurrentSpeed(10);
        testVehicle.turnLeft();
        testVehicle.turnRight();
        testVehicle.move();
        assertTrue(testVehicle.getX() == -10);
        assertTrue(testVehicle.getY() == 20);
    }
}
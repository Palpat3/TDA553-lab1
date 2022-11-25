package set;

import static org.junit.Assert.*;
import org.junit.Test;

public class MovableTest{
    @Test
    public void Movable_should_be_implemented_in_vehicle(){
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        saab.setCurrentSpeed(10);
        volvo.setCurrentSpeed(10);

        saab.turnLeft();
        volvo.turnLeft();

        saab.turnRight();
        volvo.turnRight();

        saab.move();
        volvo.move();

        assertTrue(saab.getX() == -10);
        assertTrue(volvo.getX() == -10);

        assertTrue(saab.getY() == 20);
        assertTrue(volvo.getY() == 20);
    }
}
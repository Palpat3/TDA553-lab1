package set;

import static org.junit.Assert.*;
import org.junit.Test;

public class WorkshopsTest {
    @Test
    public void Workshop_should_be_able_to_load_car(){
        Workshops workshops = new Workshops(0, 0);
        Volvo240 volvo = new Volvo240();

        workshops.loadCar(volvo);
        assertTrue(volvo.isCarInStorage());
        

    }

    @Test
    public void Workshops_should_be_able_to_remove_car(){
        Workshops workshops = new Workshops(0, 0);
        Volvo240 volvo = new Volvo240();

        workshops.loadCar(volvo);
        workshops.removeCar(volvo);

        assertFalse(volvo.isCarInStorage());

    }

    @Test
    public void Workshops_can_not_drive_on_if_far_away(){
        Workshops workshops = new Workshops(7,0);
        Volvo240 volvo = new Volvo240();

        assertThrows(ArithmeticException.class, () ->{
            workshops.loadCar(volvo);
        });
    }

    @Test
    public void Workshops_and_car_have_same_coords_when_loaded(){
        Workshops workshops = new Workshops(3,0);
        Volvo240 volvo = new Volvo240();

        workshops.loadCar(volvo);

        assertTrue(workshops.getX() == volvo.getX() && workshops.getY() == volvo.getY());
    }

    @Test
    public void Car_should_have_opposite_direction_when_removed(){
        Workshops workshops = new Workshops(3,0);
        Volvo240 volvo = new Volvo240();

        workshops.loadCar(volvo);
        workshops.removeCar(volvo);

        assertEquals(2, volvo.getDirection());
    }
}

package set;

import static org.junit.Assert.*;
import org.junit.Test;

public class WorkshopsTest {
    @Test
    public void Workshop_should_be_able_to_load_car(){

    }

    @Test
    public void Workshops_should_be_able_to_unload_car(){

    }

    @Test
    public void Workshops_can_not_drive_on_if_far_away(){
        Workshops Workshops = new Workshops(7,0);
        Volvo240 volvo = new Volvo240();

        assertThrows(ArithmeticException.class, () ->{
            Workshops.LoadCar(volvo);
        });
    }
}

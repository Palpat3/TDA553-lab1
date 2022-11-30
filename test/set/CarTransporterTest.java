package set;

import static org.junit.Assert.*;
import org.junit.Test;

public class CarTransporterTest {
    @Test
    public void Ramp_can_be_down_if_CarTransporter_is_stationairy(){
        CarTransporter carTransporter = new CarTransporter();
        
        carTransporter.LowerRamp();

        assertFalse(carTransporter.isRampUp());
    }

    @Test
    public void CarTransporter_can_not_move_when_ramp_is_down(){
        CarTransporter carTransporter = new CarTransporter();
        
        carTransporter.LowerRamp();

        assertThrows(ArithmeticException.class, () ->{
            carTransporter.move();
        });
    }

    @Test
    public void Ramp_can_not_be_lowered_when_moving(){
        CarTransporter carTransporter = new CarTransporter();

        carTransporter.setCurrentSpeed(5);

        assertThrows(ArithmeticException.class, () ->{
            carTransporter.LowerRamp();
        });
    }

    @Test
    public void Car_can_not_drive_on_if_ramp_is_up(){
        CarTransporter carTransporter = new CarTransporter();
        Volvo240 volvo = new Volvo240();
        
        
        assertThrows(ArithmeticException.class, () ->{
            carTransporter.LoadCar(volvo);
        });
    }

    @Test
    public void Car_can_not_drive_on_if_CarTransporter_is_full(){
        CarTransporter carTransporter = new CarTransporter();
        Volvo240 volvo = new Volvo240();
        Volvo240 volvo1 = new Volvo240();
        Volvo240 volvo2 = new Volvo240();
        Volvo240 volvo3 = new Volvo240();
        Volvo240 volvo4 = new Volvo240();
        Volvo240 volvo5 = new Volvo240();

        carTransporter.LowerRamp();

        carTransporter.LoadCar(volvo);
        carTransporter.LoadCar(volvo1);
        carTransporter.LoadCar(volvo2);
        carTransporter.LoadCar(volvo3);
        carTransporter.LoadCar(volvo4);

        assertThrows(ArithmeticException.class, () ->{
            carTransporter.LoadCar(volvo5);
        });
    }

    @Test
    public void Car_can_not_drive_off_if_ramp_is_up(){
        CarTransporter carTransporter = new CarTransporter();
        Volvo240 volvo = new Volvo240();

        carTransporter.LowerRamp();

        carTransporter.LoadCar(volvo);

        carTransporter.LiftRamp();
        
        
        assertThrows(ArithmeticException.class, () ->{
            carTransporter.RemoveCar(volvo);
        });
    }

    @Test
    public void Car_can_not_drive_off_if_ramp_is_emoty(){
        CarTransporter carTransporter = new CarTransporter();
        Volvo240 volvo = new Volvo240();
        
        
        assertThrows(ArithmeticException.class, () ->{
            carTransporter.RemoveCar(volvo);
        });
    }

    @Test
    public void Car_can_not_drive_on_if_far_away(){
        CarTransporter carTransporter = new CarTransporter();
        Volvo240 volvo = new Volvo240();

        volvo.setCurrentSpeed(50);
        volvo.move();

        carTransporter.LowerRamp();

        assertThrows(ArithmeticException.class, () ->{
            carTransporter.LoadCar(volvo);
        });
    }

    @Test
    public void Car_and_CarTransporter_should_have_the_same_coords_when_Car_is_on(){
        CarTransporter carTransporter = new CarTransporter();
        Volvo240 volvo = new Volvo240();

        carTransporter.LowerRamp();

        carTransporter.LoadCar(volvo);

        carTransporter.LiftRamp();

        carTransporter.startVehicle();
        carTransporter.gas(0.5);
        carTransporter.move();
        carTransporter.turnLeft();
        carTransporter.move();
        carTransporter.turnLeft();

        assertTrue(volvo.getX() == carTransporter.getX() && volvo.getY() == carTransporter.getY());
    }


}
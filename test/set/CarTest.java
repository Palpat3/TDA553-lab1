package set;

import static org.junit.Assert.*;
import org.junit.Test;

public class CarTest{

    @Test
    public void Car_should_not_be_able_to_gas_if_in_storage(){
        Saab95 saab = new Saab95();
        CarTransporter carTransporter = new CarTransporter();

        carTransporter.lowerRamp();
        carTransporter.loadCar(saab);

        assertThrows(ArithmeticException.class, () ->{
            saab.gas(0.5);
        });


    }

    @Test
    public void Car_should_not_be_able_to_move_if_in_storage(){
        Volvo240 volvo = new Volvo240();
        Workshops workshop = new Workshops(0,0);

        workshop.loadCar(volvo);

        assertThrows(ArithmeticException.class, () ->{
            volvo.move();
        });


    }
}
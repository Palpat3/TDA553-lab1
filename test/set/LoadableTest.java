package set;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class LoadableTest{
    @Test
    public void Loadable_should_be_implemented_in_CarStorage(){
        CarStorage carStorage = new CarStorage(5);

        assertTrue(carStorage.getMinDistanceToStoreCar() == 4);

        CarTransporter carTransporter = new CarTransporter();

        Volvo240 volvo = new Volvo240();

      

        




    }}
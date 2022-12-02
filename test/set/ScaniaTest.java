package set;

import static org.junit.Assert.*;
import org.junit.Test;

public class ScaniaTest {
    @Test
    public void Scania_should_not_be_able_to_start_if_platformAngle_is_not_0(){
        Scania scania = new Scania();

        scania.setCurrentSpeed(5);
        

        assertThrows(ArithmeticException.class, () ->{
            scania.changePlatformAngle(50);
        });
    }

    @Test
    public void Scania_platform_should_not_be_more_than_70(){
        Scania scania = new Scania();
        

        assertThrows(IllegalArgumentException.class, () ->{
            scania.changePlatformAngle(80);
        });
    }

    @Test
    public void Scania_platform_should_not_be_less_than_0(){
        Scania scania = new Scania();
        

        assertThrows(IllegalArgumentException.class, () ->{
            scania.changePlatformAngle(-5);
        });
    }
}

package set;

import static org.junit.Assert.*;
import org.junit.Test;


public class CarTest{
    @Test
    public void Car_should_be_abstract(){
    assertThrows(ExceptionType.class, () -> new Car(null, null, null, null, null, null, null, null));
    }
}
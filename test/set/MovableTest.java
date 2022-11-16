package set;

import static org.junit.Assert.*;
import org.junit.Test;

public abstract class MovableTest{
    public abstract MyInterface createInstance();

    @Test
    public void Movable_should_have_instances(){

    }

}

public class MyClassOneTest extends MovableTest{
    public MyInterface createInstance(){
        return new Car
    }
}

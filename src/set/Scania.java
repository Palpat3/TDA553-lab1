package set;

import java.awt.*;

public class Scania extends Truck{
   
    
    public Scania(){
        super(2, 90, Color.green, "Scania", 0, 0);
    }

    protected double speedFactor(){
        return 0;
    }
}
    

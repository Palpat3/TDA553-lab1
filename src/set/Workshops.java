package set;

import java.util.ArrayList;
import java.util.List;

public class Workshops {
    private int maxCarsinWorkshop;
    private List<Car> carsInWorkshop = new ArrayList<>(maxCarsinWorkshop);


    public void setMaxCarsinWorkshop(int maxCarsinWorkshop) {
        this.maxCarsinWorkshop = maxCarsinWorkshop;
    }

    
    public void DriveCarInWorkshop(Car car){
        if(carsInWorkshop.size() < maxCarsinWorkshop){
            carsInWorkshop.add(car);
        }
    }

    public void RemoveCarFromWorkshop(Car car){
        if(carsInWorkshop.contains(car)){
            carsInWorkshop.remove(car); 
        }
    }
}

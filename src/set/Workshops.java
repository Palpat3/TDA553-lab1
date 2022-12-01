package set;

import java.util.ArrayList;
import java.util.List;

public class Workshops implements Loadable {

    private int x;
    private int y;
    private int maxCarsinWorkshop;
    private int minDistanceToDriveOnTruck = 4;
    private List<Car> carsInWorkshop = new ArrayList<>(maxCarsinWorkshop);


    public void setMaxCarsinWorkshop(int maxCarsinWorkshop) {
        this.maxCarsinWorkshop = maxCarsinWorkshop;
    }

    public boolean IsCarCloseEnough(Car car){
        int xDiff = x - car.getX();
        int yDiff = y - car.getY();
        return Math.sqrt(Math.pow(xDiff, 2) + (Math.pow(yDiff, 2))) < minDistanceToDriveOnTruck;
    }

    
    public void LoadCar(Car car){
        if(carsInWorkshop.size() < maxCarsinWorkshop && IsCarCloseEnough(car)){
            carsInWorkshop.add(car);
        }
    }

    public void RemoveCar(Car car){
        if(carsInWorkshop.contains(car)){
            carsInWorkshop.remove(car); 
            SetPosition(car);
        }
    }

    public void SetPosition(Car car){
        car.setX(x);
        car.setY(y);
    }

}

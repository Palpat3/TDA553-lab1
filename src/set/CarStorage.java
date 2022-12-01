package set;

import java.util.ArrayList;
import java.util.List;

public class CarStorage implements Loadable{

    private int maxCarsinStorage;
    private final int minDistanceToStoreCar = 4;
    private List<Car> carsInStorage = new ArrayList<>(maxCarsinStorage);

    public CarStorage(int maxCarsinStorage){
        this.maxCarsinStorage = maxCarsinStorage;
    }

    public int getMinDistanceToStoreCar() {
        return minDistanceToStoreCar;
    }

    public void LoadCar(Car car){
        if ((carsInStorage.size() < maxCarsinStorage) && !carsInStorage.contains(car)){
            carsInStorage.add(car);
            car.DriveCarInStorage();
        }
        else if(carsInStorage.size() == maxCarsinStorage){
            throw new ArithmeticException("Car transporter already full");
        }
    } 
        
    public void RemoveCar(Car car){
        if (carsInStorage.contains(car)){
            carsInStorage.remove(car);
            car.DriveCarOutOfStorage();
        }
        else if(carsInStorage.size() == 0){
            throw new ArithmeticException("Car transporter is empty");
        }
        else{
            throw new ArithmeticException("Car is not in storage!");
        }
    }

    public List<Car> getCarsInStorage() {
        return carsInStorage;
    }

    

    
    
}

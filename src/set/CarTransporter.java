package set;

import java.awt.*;
import java.util.*;

public class CarTransporter extends Truck {

    
    private boolean rampUp = true;
    private final int maxCarsOnTruck = 5;
    private ArrayList<Car> CarsOnTruck = new ArrayList<>(maxCarsOnTruck);

    public CarTransporter(){
        super(2, 90, Color.green, "Car Transporter", 0, 0);
    }

    public void LiftRamp(){
        rampUp = true;
    }

    public void LowerRamp(){
        if (getCurrentSpeed() == 0){
          rampUp = false;  
        }
        else{
            throw new ArithmeticException("You have to be stationairy to move platform");
        }
        
    }

    public void DriveCarOnTruck(Car car){
        if (rampUp == false && (CarsOnTruck.size() < maxCarsOnTruck)){
            CarsOnTruck.add(car);
            car.GetCarOnTruck();
        }
        else if(rampUp){
            throw new ArithmeticException("Platform has to be down for cars to drive on");
        }
        else{
            throw new ArithmeticException("Car transporter already full");
        }

    }

    public void RemoveCarFromTruck(Car car){
        if (rampUp == false && CarsOnTruck.size() > 0 && car.isCarOnTruck()){
            CarsOnTruck.remove(CarsOnTruck.indexOf(car));
            car.GetCarOffTruck();
        }
        else if(rampUp){
            throw new ArithmeticException("Platform has to be down for cars to drive off");
        }
        else{
            throw new ArithmeticException("Car transporter is empty");
        }
    }


    @Override
    public void move(){
        if (rampUp){
            super.move();
        }
        else{
            throw new ArithmeticException("Can't drive with the ramp down!");
        }
    }

       
}

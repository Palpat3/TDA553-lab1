package set;

import java.util.Random;


public class Workshops{

    private int x;
    private int y;
    Random r = new Random();
    private Loadable storage = new CarStorage(r.nextInt(9) + 1);

    public Workshops(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean IsCarCloseEnoughToStore(Car car){
        int xDiff = this.getX() - car.getX();
        int yDiff = this.getY() - car.getY();
        return Math.sqrt(Math.pow(xDiff, 2) + (Math.pow(yDiff, 2))) < storage.getMinDistanceToStoreCar();
    }

    public void LoadCar(Car car){
        if(IsCarCloseEnoughToStore(car)){
            storage.LoadCar(car);
        }
        else{
            throw new ArithmeticException("Car is too far away");
        }
    }

    public void RemoveCar(Car car){
        storage.RemoveCar(car);
        SetPosition(car);
        
    }

    public void SetPosition(Car car){
        car.setX(x);
        car.setY(y);
        TurnCarAround(car);
    }

    private void TurnCarAround(Car car){
        car.turnLeft();
        car.turnLeft();
    }

}

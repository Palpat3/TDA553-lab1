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

    public boolean isCarCloseEnoughToStore(Car car){
        int xDiff = this.getX() - car.getX();
        int yDiff = this.getY() - car.getY();
        return Math.sqrt(Math.pow(xDiff, 2) + (Math.pow(yDiff, 2))) < storage.getMinDistanceToStoreCar();
    }

    public void loadCar(Car car){
        if(isCarCloseEnoughToStore(car)){
            storage.loadCar(car);
            setPosition(car);
        }
        else{
            throw new ArithmeticException("Car is too far away");
        }
    }

    public void removeCar(Car car){
        storage.removeCar(car);
        turnCarAround(car);
        
    }

    private void setPosition(Car car){
        car.setX(x);
        car.setY(y);
    }

    private void turnCarAround(Car car){
        car.turnLeft();
        car.turnLeft();
    }

}

package set;

public interface Loadable {
    boolean IsCarCloseEnough(Car car);
    void LoadCar(Car car);
    void RemoveCar(Car car);
    void SetPosition(Car car);
}

package set;

import java.util.List;

public interface Loadable {
    int getMinDistanceToStoreCar();
    List<Car> getCarsInStorage();
    void LoadCar(Car car);
    void RemoveCar(Car car);
}

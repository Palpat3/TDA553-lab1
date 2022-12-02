package set;

import java.util.List;

public interface Loadable {
    int getMinDistanceToStoreCar();
    List<Car> getCarsInStorage();
    void loadCar(Car car);
    void removeCar(Car car);
}

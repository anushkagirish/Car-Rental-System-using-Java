package car_rental;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void updateCar(String id, Car updatedCar) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                car.setMake(updatedCar.getMake());
                car.setModel(updatedCar.getModel());
                car.setYear(updatedCar.getYear());
                car.setAvailable(updatedCar.isAvailable());
                break;
            }
        }
    }

    public void deleteCar(String id) {
        cars.removeIf(car -> car.getId().equals(id));
    }

    public Car getCar(String id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    public List<Car> getAllCars() {
        return cars;
    }
}


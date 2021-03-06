package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarService {
    private final List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Audi", "black", 80));
        cars.add(new Car("BMW", "blue", 7));
        cars.add(new Car("Ferrari", "red", 500));
        cars.add(new Car("Bugatti", "yellow", 911));
        cars.add(new Car("Passat", "white", 5));
    }

    public List<Car> getCarCount(Integer count) {
        if (count == null) {
            return cars;
        }
        return cars.stream().limit(count).toList();
    }
}

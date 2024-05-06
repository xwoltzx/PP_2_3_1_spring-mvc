package web.service;

import org.springframework.stereotype.Component;
import web.entity.Car;

import java.util.ArrayList;
import java.util.List;
@Component
public class CarServiceImpl implements CarService{
    List<Car> cars;
    public CarServiceImpl() {
        cars = new ArrayList<>();
        cars.add(new Car("Renault Logan", 2014, "Alexey Vlasov"));
        cars.add(new Car("Ford Focus", 2019, "Vitaliy Smirnov"));
        cars.add(new Car("Lexus LX 570", 2021, "Vladimir Dobronravov"));
        cars.add(new Car("Audi R8", 2014, "Vitaliy Yudin"));
        cars.add(new Car("BMW X5", 2020, "Dmitriy Chesnokov"));
    }
    public List<String> carList(int num) {
        if (num >= 5) {
            num = 5;
        } else if (num <= 0) {
            num = 0;
        }
        return cars.stream().map(car -> car.toString()).toList().subList(0,num);
    }
}

package db;

import bean.Car;

import java.util.List;

public class CarRepository implements BaseCrudRepository<Car> {
    List<Car> cars = DataBase.getCars();
    @Override
    public Car add(Car bean) {
        bean.setId(cars.size());
        cars.add(bean);
        return bean;
    }

    @Override
    public Car get(Integer id) {
        return null;
    }

    @Override
    public Boolean update(Car newBean) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }
}

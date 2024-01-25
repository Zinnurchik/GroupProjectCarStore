package resource;

import bean.ApiResponce;
import bean.Car;
import db.CarRepository;

public class CarsResource implements BaseCrudResource<Car>{
    CarRepository repository = new CarRepository();
    @Override
    public ApiResponce add(Car bean) {
        Car newCar = repository.add(bean);
        return new ApiResponce(200, "Successfully created", newCar);
    }

    @Override
    public ApiResponce get(Integer id) {
        return null;
    }

    @Override
    public ApiResponce update(Car newBean) {
        return null;
    }

    @Override
    public ApiResponce delete(Integer id) {
        return null;
    }
}

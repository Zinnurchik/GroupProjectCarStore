package db;

import bean.Car;
import bean.User;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static List<User> users = new ArrayList<>();
    private static List<Car> cars = new ArrayList<>();
    public static User session = null;

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        DataBase.users = users;
    }

    public static List<Car> getCars() {
        return cars;
    }

    public static void setCars(List<Car> cars) {
        DataBase.cars = cars;
    }
}

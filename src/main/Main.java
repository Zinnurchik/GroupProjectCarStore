package main;

import bean.ApiResponce;
import bean.Car;
import bean.User;
import db.DataBase;
import resource.CarsResource;
import resource.UsersResource;
import java.util.Scanner;
import static db.DataBase.*;

public class Main {
    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    static Scanner intSc = new Scanner(System.in);
    static Scanner stSc = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        System.out.println("0. Exit");
        if (session == null) {
            System.out.println("1. Login");
            System.out.println("2. Register");
        } else {
            System.out.println("WELCOME");
            System.out.println("3. Add car");
            System.out.println("4. My cars");
            System.out.println("5. To sale");
            System.out.println("6. To buy");
            System.out.println("100. Log out");

            System.out.println(session.getBalance());
        }

        int choice = intSc.nextInt();
        switch (choice) {
            case 0 -> {
                return;
            }
            case 1 -> login();
            case 2 -> register();
            case 3 -> addCar();
            case 4 -> showMyCars();
            case 5 -> sale();
            case 6 -> buy();

            case 100 -> logout();
        }
    }

    private static void buy() {
        for (int i = 0; i < DataBase.getCars().size(); i++) {
            Car current = DataBase.getCars().get(i);
            if (session.getId() != current.getUserId() && current.getInStore()){
                System.out.println("Id: " + current.getId());
                System.out.println("Name: " + current.getName());
                System.out.println("Color: " + current.getColor());
                System.out.println("Price: " + current.getPrice());
                System.out.println("Status: Sotuvda");
            }
        }
        int id = stSc.nextInt();
        if(id >= DataBase.getCars().size()){
            showMenu();
        }
        for (int i = 0; i < DataBase.getCars().size(); i++) {
            Car current = DataBase.getCars().get(i);
            if(current.getId() == id && current.getUserId() != session.getId() && current.getInStore()){
                if(session.getBalance() >= current.getPrice()){
                    User owner = DataBase.getUsers().get(current.getUserId());
                    session.setBalance(session.getBalance() - current.getPrice());
                    owner.setBalance(owner.getBalance() + current.getPrice());
                    current.setUserId(session.getId());
                    current.setInStore(false);
                    System.out.println("Successful");
                    break;
                }
                else {
                    System.out.println("Your balance is not enough");
                    showMenu();
                }
            }
        }
    }

    private static void sale() {
        for (int i = 0; i < DataBase.getCars().size(); i++) {
            Car current = DataBase.getCars().get(i);
            if (session.getId() == current.getUserId() && !current.getInStore()){
                System.out.println("Id: " + current.getId());
                System.out.println("Name: " + current.getName());
                System.out.println("Color: " + current.getColor());
                System.out.println("Price: " + current.getPrice());
                System.out.println("Status: Garajda");
            }
        }
        int id = stSc.nextInt();
        for (int i = 0; i < DataBase.getCars().size(); i++) {
            Car current = DataBase.getCars().get(i);
            if(current.getId() == id && current.getUserId() == session.getId()){
                current.setInStore(true);
                System.out.println("Successful");
                break;
            }
        }
        showMenu();
    }

    private static void showMyCars() {
        for (int i = 0; i < DataBase.getCars().size(); i++) {
            Car current = DataBase.getCars().get(i);
            if (session.getId() == current.getUserId()){
                System.out.println("Name: " + current.getName());
                System.out.println("Color: " + current.getColor());
                System.out.println("Price: " + current.getPrice());
                if(current.getInStore())
                    System.out.println("Status: Sotuvda");
                else
                    System.out.println("Status: Garajda");
            }
        }
        showMenu();
    }

    private static void addCar() {
        intSc = new Scanner(System.in);
        stSc = new Scanner(System.in);

        CarsResource carsResource = new CarsResource();

        System.out.print("Car name: ");
        String name = stSc.nextLine();
        System.out.print("Car color: ");
        String color = stSc.nextLine();
        System.out.print("Car price: ");
        double price = intSc.nextDouble();

        if(price > session.getBalance()){
            System.out.println("More high price");
            showMenu();
        }else {
            session.setBalance(session.getBalance() - price);
        }
        Car newCar = new Car(name, color, price, session.getId());
        ApiResponce apiResponce = carsResource.add(newCar);

        System.out.println(apiResponce.getMessage());

        Car car = (Car) apiResponce.getData();
        System.out.println(car.getName());
        System.out.println(car.getUserId());
        System.out.println(car.getId());
        showMenu();
    }

    private static void logout() {
        session = null;
        showMenu();
    }

    private static void login() {
        stSc = new Scanner(System.in);
        UsersResource usersResource = new UsersResource();

        System.out.print("User name: ");
        String login = stSc.next();
        System.out.print("Password: ");
        String password = stSc.next();

        ApiResponce apiResponce = usersResource.login(new User(login, password));

        session = (User) apiResponce.getData();
        showMenu();
    }
    private static void register() {
        UsersResource usersResource = new UsersResource();
        stSc = new Scanner(System.in);

        System.out.print("User name: ");
        String login = stSc.next();
        System.out.print("Password: ");
        String password = stSc.next();

        ApiResponce apiResponce = usersResource.add(new User(login, password));
        System.out.println(apiResponce.getMessage());
        session = (User) apiResponce.getData();
        showMenu();
    }
}
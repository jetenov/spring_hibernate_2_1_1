package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void clean();
    void drop();
    List<User> selectUserByCar(String model, int series);
    List<User> listUsers();
    List<Car> listCars();
}

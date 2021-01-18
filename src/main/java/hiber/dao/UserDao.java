package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   void clean();
   void drop();
   List<User> selectUserByCar(String model, int series);
   List<User> listUsers();
   List<Car> listCars();
}

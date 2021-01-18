package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      //userService.clean();
      Car car1 = new Car(777, "Porsh");
      Car car2 = new Car(888, "Ferrari");
      Car car3 = new Car(999, "Lambo");

      //userService.add(new User("Aibat", "Jetenov", "jetenov@mail.ru", car1));
      //userService.add(new User("Leo", "Messi", "messi@mail.ru", car2));
      //userService.add(new User("Luis", "Suarez", "Suerez@mail.ru", car3));
      //userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      //List<User> users = userService.listUsers();
      List<User> users = userService.selectUserByCar("Ferrari", 888);
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("CarID = "+user.getCar().getId());
         System.out.println();
      }

//      List<Car> cars = userService.listCars();
//      for (Car car : cars) {
//         System.out.println("id = "+car.getId());
//         System.out.println("Model = "+car.getModel());
//         System.out.println("Series = "+car.getSeries());
//         System.out.println();
//      }

      context.close();
   }
}

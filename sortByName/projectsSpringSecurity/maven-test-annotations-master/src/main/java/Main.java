import models.Auto;
import models.User;
import services.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserService();
        User user = new User("Masha", 26);
        userService.saveUser(user);
        Auto ferrari = new Auto("Ferrari", "red");
        Auto ford = new Auto("Ford", "black");
        user.addAuto(ferrari);
        Auto opel = new Auto("Opel", "red");
        Auto bmw = new Auto("BMW", "blue");
        user.addAuto(opel);
        user.addAuto(bmw);
        ford.setUser(user);
        user.addAuto(ford);
        //userService.updateUser(user);
        //user.setName("Sasha");
        //userService.updateUser(user);

        System.out.print(userService.findUser(26).getAutos() + user.getName());
    }
}

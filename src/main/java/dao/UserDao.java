package dao;

import web.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   User getUserByCar(String model, int series);

   int clean();
}
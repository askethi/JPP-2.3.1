package web.service;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void deleteUserById(Long id);
    void updateUserById(User user, Long id);
    List<User> listUsers();
    User getUserById(Long id);
    int clean();
}

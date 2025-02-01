package microservicetask.service;

import microservicetask.model.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    User readUser(int id);

    void deleteUser(int id);

    List<User> getUsersAndRoles();

    User getUserById(int id);
}


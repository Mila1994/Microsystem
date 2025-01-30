package microservicetask_7.service;

import microservicetask_7.model.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    User readUser(int id);

    void deleteUser(int id);

    List<User> getUsersAndRoles();
}


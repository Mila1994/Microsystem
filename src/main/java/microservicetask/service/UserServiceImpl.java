package microservicetask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import microservicetask.model.User;
import microservicetask.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void createUser(User user) {
        userRepository.save(user);

    }

    @Transactional(readOnly = true)
    @Override
    public User readUser(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Transactional
    public void updateUser(int id, User updatedUser) {
        updatedUser.setId(id);
        userRepository.save(updatedUser);

    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<User> getUsersAndRoles() {
        return userRepository.listUsersAndRoles();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.save(userRepository.findById(id).get());
    }
}

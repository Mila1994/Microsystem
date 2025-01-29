package taskSpringPlusHibernate.service;

import org.springframework.stereotype.Service;
import taskSpringPlusHibernate.model.User;
import taskSpringPlusHibernate.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user); // save() работает и для обновления
    }

    @Override
    public void removeUserById(Long id) {
        userRepository.deleteById(id);
    }
}
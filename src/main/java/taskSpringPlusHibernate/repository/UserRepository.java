package taskSpringPlusHibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taskSpringPlusHibernate.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
package microservicetask_7;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import microservicetask_7.model.Role;
import microservicetask_7.model.User;
import microservicetask_7.repository.RoleRepository;
import microservicetask_7.repository.UserRepository;

import java.util.Set;

@SpringBootApplication
public class DemoApplication {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public DemoApplication(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner addInitialUsers() {
        return args -> {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


            Role adminRole = roleRepository.findByName("ROLE_ADMIN");
            if (adminRole == null) {
                adminRole = new Role("ROLE_ADMIN");
                roleRepository.save(adminRole);
            }


            Role userRole = roleRepository.findByName("ROLE_USER");
            if (userRole == null) {
                userRole = new Role("ROLE_USER");
                roleRepository.save(userRole);
            }


            if (userRepository.findByUsername("Admin") == null) {
                User adminUser = new User();
                adminUser.setEmail("admin@example.com");
                adminUser.setUsername("Admin");
                adminUser.setPassword(passwordEncoder.encode("user123"));
                adminUser.setRoles(Set.of(adminRole));
                userRepository.save(adminUser);
            }


            if (userRepository.findByUsername("User") == null) {
                User regularUser = new User();
                regularUser.setEmail("user@example.com");
                regularUser.setUsername("User");
                regularUser.setPassword(passwordEncoder.encode("user123"));
                regularUser.setRoles(Set.of(userRole));
                userRepository.save(regularUser);
            }
        };
    }
}
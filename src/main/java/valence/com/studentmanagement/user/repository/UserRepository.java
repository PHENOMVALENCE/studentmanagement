package valence.com.studentmanagement.user.repository;

import valence.com.studentmanagement.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    void save(org.springframework.boot.autoconfigure.security.SecurityProperties.User user);
}

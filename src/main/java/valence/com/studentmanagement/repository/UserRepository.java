package valence.com.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import valence.com.studentmanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    void save(org.springframework.boot.autoconfigure.security.SecurityProperties.User user);
}

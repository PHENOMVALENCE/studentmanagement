package valence.com.studentmanagement.service.user;

import java.util.Optional;
import valence.com.studentmanagement.model.User;

public interface UserService {
    Optional<User> getUserByUsername(String username);
    User updateUser(User user);
}

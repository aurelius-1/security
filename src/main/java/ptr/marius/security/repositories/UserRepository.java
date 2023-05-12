package ptr.marius.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ptr.marius.security.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u from User u WHERE u.username = :username")
    Optional<User> findUserByUsername(String username);
}

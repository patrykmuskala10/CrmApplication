package pl.patrykmuskala.CrmApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patrykmuskala.CrmApplication.Model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Iterable<User> findAllByName(String name);
    Optional<User> findByUsername(String username);


}

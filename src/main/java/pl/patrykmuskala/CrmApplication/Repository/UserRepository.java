package pl.patrykmuskala.CrmApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patrykmuskala.CrmApplication.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Iterable<User> findAllByName(String name);
    Iterable<User> findAllBySurname(String name);
    Iterable<User> findAllByRole_Name(String name);


}

package pl.patrykmuskala.CrmApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patrykmuskala.CrmApplication.Model.Customer;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

package pl.patrykmuskala.CrmApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patrykmuskala.CrmApplication.Model.Customer;
import pl.patrykmuskala.CrmApplication.Model.User;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Iterable<Customer> findAllByName(String name);
    Iterable<Customer> findAllBySurname(String name);
    Iterable<Customer> findAllByPhoneNumber(String phoneNumber);
    Iterable<Customer> findAllByPesel(String pesel);
    Iterable<Customer> findAllByAddress_Street(String street);
    Iterable<Customer> findAllByAddress_City(String city);
    Iterable<Customer> findAllByAddress_PostalCode(String postalCode);


}

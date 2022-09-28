package pl.patrykmuskala.CrmApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patrykmuskala.CrmApplication.Model.Customer;
import pl.patrykmuskala.CrmApplication.Model.Order;
@Repository

public interface OrderRepository extends JpaRepository<Order, Integer> {

    Iterable<Order> findAllByCustomer_Name(String street);
    Iterable<Order> findAllByCustomer_Surname(String street);
    Iterable<Order> findAllByCustomer_PhoneNumber(String street);
    Iterable<Order> findAllByCustomer_Pesel(String pesel);
    Iterable<Order> findAllByCustomer_Address_City(String city);
    Iterable<Order> findAllByCustomer_Address_PostalCode(String postalCode);
    Iterable<Order> findAllByCustomer_Address_Street(String street);
    Iterable<Order> findAllByPanel_Model(String model);
    Iterable<Order> findAllByPanel_Manufacturer(String manufacturer);
    Iterable<Order> findAllByInverter_Model(String model);
    Iterable<Order> findAllByInverter_Manufacturer(String manufacturer);
    Iterable<Order> findAllByUser_Name(String name);
    Iterable<Order> findAllByUser_Surname(String surname);
    Iterable<Order> findAllBySalesman_Name(String name);
    Iterable<Order> findAllBySalesman_Surname(String surname);
    Iterable<Order> findAllBySalesman_Team_Name(String team);
    Iterable<Order> findAllByOrderStatus_Name(String name);
    Iterable<Order> findAllByInstallationAddress_City(String city);
    Iterable<Order> findAllByInstallationAddress_PostalCode(String postalCode);
    Iterable<Order> findAllByInstallationAddress_Street(String street);
}

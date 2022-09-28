package pl.patrykmuskala.CrmApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.patrykmuskala.CrmApplication.Model.Customer;
import pl.patrykmuskala.CrmApplication.Repository.CustomerRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public Iterable<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/id={id}")
    public Optional<Customer> getCustomerById(@PathVariable(value = "id") int id) {
        return customerRepository.findById(id);
    }

    @GetMapping("/name={name}")
    public Iterable<Customer> getCustomersByName(@PathVariable(value = "name") String name) {
        return customerRepository.findAllByName(name);
    }

    @GetMapping("/surname={surname}")
    public Iterable<Customer> getCustomersBySurname(@PathVariable(value = "surname") String surname) {
        return customerRepository.findAllBySurname(surname);
    }

    @GetMapping("/phoneNumber={phoneNumber}")
    public Iterable<Customer> getCustomersByPhoneNumber(@PathVariable(value = "phoneNumber") String phoneNumber) {
        return customerRepository.findAllByPhoneNumber(phoneNumber);
    }

    @GetMapping("/pesel={pesel}")
    public Iterable<Customer> getCustomersByPesel(@PathVariable(value = "pesel") String pesel) {
        return customerRepository.findAllByPesel(pesel);
    }

    @GetMapping("/city={city}")
    public Iterable<Customer> getCustomersByAddress_City(@PathVariable(value = "city") String city) {
        return customerRepository.findAllByAddress_City(city);
    }

    @GetMapping("/street={street}")
    public Iterable<Customer> getCustomersByAddress_Street(@PathVariable(value = "street") String street) {
        return customerRepository.findAllByAddress_Street(street);
    }

    @GetMapping("/postalCode={postalCode}")
    public Iterable<Customer> getCustomersByAddress_PostalCode(@PathVariable(value = "postalCode") String postalCode) {
        return customerRepository.findAllByAddress_PostalCode(postalCode);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
}

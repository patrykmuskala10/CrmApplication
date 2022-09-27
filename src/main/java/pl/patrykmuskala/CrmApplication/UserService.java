package pl.patrykmuskala.CrmApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.patrykmuskala.CrmApplication.Model.*;
import pl.patrykmuskala.CrmApplication.Repository.*;

import java.time.LocalDate;

@RestController
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    SalesmanRepository salesmanRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/users")
    public Iterable<User> getUsers(){
        Role exampleRole = new Role("Admin");
        User exampleUser = new User("Anna", "Nowak", exampleRole);
        userRepository.save(exampleUser);
        Iterable<User> users = userRepository.findAll();
        System.out.println("/users used");
        return users;
    }

    @GetMapping("/salesmen")
    public Iterable<Salesman> getSalesmen(){
        Team exampleTeam = new Team("AndOne");
        Salesman exampleSalesman = new Salesman("Michael", "Jordan", exampleTeam);
        salesmanRepository.save(exampleSalesman);
        Iterable<Salesman> salesmen = salesmanRepository.findAll();
        System.out.println("/salesmen used");
        return salesmen;
    }

    @GetMapping("/orders")
    public Iterable<Order> getOrders(){
        Address customerAddress = new Address("Przykładowe miasto", "12-345", "Przykładowa ulica", 1, 2);
        Address installationAddress = new Address("Przykładowa wieś", "67-890", "Przykładowa aleja", 3);
        Customer customer = new Customer("Jan", "Nowak", "123-456-789", "987-654-321", "12345678901", customerAddress);
        Panel panel = new Panel("Longi Solar", "Fullblack 400 Wp");
        Inverter inverter = new Inverter("Solar Edge", "SE 8 K");
        Role role = new Role("Back Office");
        User user = new User("Adam", "Kowalski", role);
        Team team = new Team("Dream Team");
        Salesman salesman = new Salesman("Andrzej", "Dzida", team);
        LocalDate installationDate = LocalDate.now();
        OrderStatus orderStatus = new OrderStatus("Design");

        Order exampleOrder = new Order(customer, panel, 15, inverter, 1, user, salesman, installationDate, orderStatus, installationAddress);
        orderRepository.save(exampleOrder);
        Iterable<Order> orders = orderRepository.findAll();
        System.out.println("/orders used");
        return orders;
    }
    @GetMapping("/customers")
    public Iterable<Customer> getCustomers(){
        Address customerAddress = new Address("Przykładowe miasto", "12-345", "Przykładowa ulica", 1, 2);
        Customer customer = new Customer("Jan", "Nowak", "123-456-789", "987-654-321", "12345678901", customerAddress);
        customerRepository.save(customer);
        Iterable<Customer> customers = customerRepository.findAll();
        System.out.println("/cusomers udes");
        return customers;
    }

    @GetMapping("/addresses")
    public Iterable<Address> getAddresses(){
        Address customerAddress = new Address("Przykładowe miasto", "12-345", "Przykładowa ulica", 1, 2);
        addressRepository.save(customerAddress);
        Iterable<Address> addresses = addressRepository.findAll();
        System.out.println("/addresses used");
        return addresses;
    }
}

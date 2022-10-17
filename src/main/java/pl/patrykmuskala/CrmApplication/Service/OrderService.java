package pl.patrykmuskala.CrmApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.patrykmuskala.CrmApplication.Model.*;
import pl.patrykmuskala.CrmApplication.Repository.OrderRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping
    public Iterable<Order> getOrders(){
        Iterable<Order> orders = orderRepository.findAll();
        return orders;
    }

    @GetMapping("/id={id}")
    public Optional<Order> getOrderById(@PathVariable(value = "id") int id) {
        return orderRepository.findById(id);
    }

    @GetMapping("/customerName={customerName}")
    public Iterable<Order> getOrdersByCustomer_Name(@PathVariable(value = "customerName") String customerName) {
        return orderRepository.findAllByCustomer_Name(customerName);
    }

    @GetMapping("/customerSurname={customerSurname}")
    public Iterable<Order> getOrdersByCustomer_Surname(@PathVariable(value = "customerSurname") String customerSurname) {
        return orderRepository.findAllByCustomer_Surname(customerSurname);
    }

    @GetMapping("/customerPhoneNumber={customerPhoneNumber}")
    public Iterable<Order> getOrdersByCustomer_PhoneNumber(@PathVariable(value = "customerPhoneNumber") String customerPhoneNumber) {
        return orderRepository.findAllByCustomer_PhoneNumber(customerPhoneNumber);
    }

    @GetMapping("/customerPesel={customerPesel}")
    public Iterable<Order> getOrdersByCustomer_Pesel(@PathVariable(value = "customerPesel") String customerPesel) {
        return orderRepository.findAllByCustomer_Pesel(customerPesel);
    }

    @GetMapping("/customerCity={customerCity}")
    public Iterable<Order> getOrdersByCustomer_Address_City(@PathVariable(value = "customerCity") String customerCity) {
        return orderRepository.findAllByCustomer_Address_City(customerCity);
    }

    @GetMapping("/customerPostalCode={customerPostalCode}")
    public Iterable<Order> getOrdersByCustomer_Address_PostalCode(@PathVariable(value = "customerPostalCode") String customerPostalCode) {
        return orderRepository.findAllByCustomer_Address_PostalCode(customerPostalCode);
    }

    @GetMapping("/customerStreet={customerStreet}")
    public Iterable<Order> getOrdersByCustomer_Address_Street(@PathVariable(value = "customerStreet") String customerStreet) {
        return orderRepository.findAllByCustomer_Address_Street(customerStreet);
    }

    @GetMapping("/panelModel={panelModel}")
    public Iterable<Order> getOrdersByPanelModel(@PathVariable(value = "panelModel") String panelModel) {
        return orderRepository.findAllByPanel_Model(panelModel);
    }

    @GetMapping("/panelManufacturer={panelManufacturer}")
    public Iterable<Order> getOrdersByPanelManufacturer(@PathVariable(value = "panelManufacturer") String panelManufacturer) {
        return orderRepository.findAllByPanel_Manufacturer(panelManufacturer);
    }

    @GetMapping("/inverterModel={inverterModel}")
    public Iterable<Order> getOrdersByInverterModel(@PathVariable(value = "inverterModel") String inverterModel) {
        return orderRepository.findAllByInverter_Model(inverterModel);
    }

    @GetMapping("/inverterManufacturer={inverterManufacturer}")
    public Iterable<Order> getOrdersByInverterManufacturer(@PathVariable(value = "inverterManufacturer") String inverterManufacturer) {
        return orderRepository.findAllByInverter_Manufacturer(inverterManufacturer);
    }

    @GetMapping("/userName={userName}")
    public Iterable<Order> getOrdersByUserName(@PathVariable(value = "userName") String userName) {
        return orderRepository.findAllByUser_Name(userName);
    }

//    @GetMapping("/userSurname={userSurname}")
//    public Iterable<Order> getOrdersByUserSurname(@PathVariable(value = "userSurname") String userSurname) {
//        return orderRepository.findAllByUser_Surname(userSurname);
//    }

    @GetMapping("/salesmanName={salesmanName}")
    public Iterable<Order> getOrdersBySalesmanName(@PathVariable(value = "salesmanName") String salesmanName) {
        return orderRepository.findAllBySalesman_Name(salesmanName);
    }

    @GetMapping("/salesmanSurname={salesmanSurname}")
    public Iterable<Order> getOrdersBySalesmanSurname(@PathVariable(value = "salesmanSurname") String salesmanSurname) {
        return orderRepository.findAllBySalesman_Surname(salesmanSurname);
    }

    @GetMapping("/salesmanTeam={salesmanTeam}")
    public Iterable<Order> getOrdersBySalesmanTeam(@PathVariable(value = "salesmanTeam") String salesmanTeam) {
        return orderRepository.findAllBySalesman_Team_Name(salesmanTeam);
    }

    @GetMapping("/orderStatus={orderStatus}")
    public Iterable<Order> getOrdersByOrderStatus(@PathVariable(value = "orderStatus") String orderStatus) {
        return orderRepository.findAllByOrderStatus_Name(orderStatus);
    }

    @GetMapping("/installationCity={installationCity}")
    public Iterable<Order> getOrdersByInstallationAddressCity(@PathVariable(value = "installationCity") String installationCity) {
        return orderRepository.findAllByInstallationAddress_City(installationCity);
    }

    @GetMapping("/installationPostalCode={installationPostalCode}")
    public Iterable<Order> getOrdersByInstallationAddressPostalCode(@PathVariable(value = "installationPostalCode") String installationPostalCode) {
        return orderRepository.findAllByInstallationAddress_PostalCode(installationPostalCode);
    }

    @GetMapping("/installationStreet={installationStreet}")
    public Iterable<Order> getOrdersByInstallationAddressStreet(@PathVariable(value = "installationStreet") String installationStreet) {
        return orderRepository.findAllByInstallationAddress_Street(installationStreet);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }
}

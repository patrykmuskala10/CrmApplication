package pl.patrykmuskala.CrmApplication.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customers_id", referencedColumnName = "id")
    private Customer customer;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "panels_id", referencedColumnName = "id")
    private Panel panel;

    @Column(nullable = false)
    private int number_of_panels;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "inverters_id", referencedColumnName = "id")
    private Inverter inverter;

    @Column(nullable = false)
    private int number_of_inverters;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "salesmen_id", referencedColumnName = "id")
    private Salesman salesman;

    @Column(nullable = true)
    private LocalDate installation_date;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_statuses_id", referencedColumnName = "id")
    private OrderStatus orderStatus;

    public Address getInstallationAddress() {
        return installationAddress;
    }

    public void setInstallationAddress(Address installationAddress) {
        this.installationAddress = installationAddress;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "addresses_id", referencedColumnName = "id")
    private Address installationAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    public int getNumber_of_panels() {
        return number_of_panels;
    }

    public void setNumber_of_panels(int numberOfPanels) {
        this.number_of_panels = numberOfPanels;
    }

    public Inverter getInverter() {
        return inverter;
    }

    public void setInverter(Inverter inverter) {
        this.inverter = inverter;
    }

    public int getNumber_of_inverters() {
        return number_of_inverters;
    }

    public void setNumber_of_inverters(int numberOfInverters) {
        this.number_of_inverters = numberOfInverters;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public LocalDate getInstallation_date() {
        return installation_date;
    }

    public void setInstallation_date(LocalDate installationDate) {
        this.installation_date = installationDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order() {
    }

    public Order(Customer customer, Panel panel, int number_of_panels, Inverter inverter, int number_of_inverters, User user, Salesman salesman, LocalDate installation_date, OrderStatus orderStatus, Address installationAddress) {
        this.customer = customer;
        this.panel = panel;
        this.number_of_panels = number_of_panels;
        this.inverter = inverter;
        this.number_of_inverters = number_of_inverters;
        this.user = user;
        this.salesman = salesman;
        this.installation_date = installation_date;
        this.orderStatus = orderStatus;
        this.installationAddress = installationAddress;
    }
}

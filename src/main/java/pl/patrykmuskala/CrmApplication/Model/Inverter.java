package pl.patrykmuskala.CrmApplication.Model;

import javax.persistence.*;

@Entity
@Table(name = "inverters")
public class Inverter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private String model;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Inverter() {
    }

    public Inverter(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }
}

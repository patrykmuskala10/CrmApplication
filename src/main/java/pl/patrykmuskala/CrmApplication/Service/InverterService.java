package pl.patrykmuskala.CrmApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.patrykmuskala.CrmApplication.Model.Inverter;
import pl.patrykmuskala.CrmApplication.Repository.InverterRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/inverters")
public class InverterService {

    @Autowired
    InverterRepository inverterRepository;

    @GetMapping()
    public Iterable<Inverter> getInverters() {
        return inverterRepository.findAll();
    }

    @GetMapping("/id={id}")
    public Optional<Inverter> getInverterById(@PathVariable(value = "id") int id) {
        return inverterRepository.findById(id);
    }

    @GetMapping("/manufacturer={manufacturer}")
    public Iterable<Inverter> getInvertersByManufacturer(@PathVariable(value = "manufacturer") String manufacturer) {
        return inverterRepository.findAllByManufacturer(manufacturer);
    }

    @PostMapping
    public Inverter createInverter(@RequestBody Inverter inverter) {
        return inverterRepository.save(inverter);
    }
}

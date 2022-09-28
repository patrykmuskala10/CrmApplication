package pl.patrykmuskala.CrmApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.patrykmuskala.CrmApplication.Model.Customer;
import pl.patrykmuskala.CrmApplication.Model.Salesman;
import pl.patrykmuskala.CrmApplication.Repository.SalesmanRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/salesmen")
public class SalesmanService {

    @Autowired
    SalesmanRepository salesmanRepository;

    @GetMapping
    public Iterable<Salesman> getSalesmen(){
        return salesmanRepository.findAll();
    }

    @GetMapping("/id={id}")
    public Optional<Salesman> getSalesmanById(@PathVariable(value = "id") int id) {
        return salesmanRepository.findById(id);
    }

    @GetMapping("/name={name}")
    public Iterable<Salesman> getSalesmenByName(@PathVariable(value = "name") String name) {
        return salesmanRepository.findAllByName(name);
    }

    @GetMapping("/surname={surname}")
    public Iterable<Salesman> getSalesmenBySurname(@PathVariable(value = "surname") String surname) {
        return salesmanRepository.findAllBySurname(surname);
    }

    @GetMapping("/team={team}")
    public Iterable<Salesman> getCustomersByTeam_Name(@PathVariable(value = "team") String team) {
        return salesmanRepository.findAllByTeam_Name(team);
    }

    @PostMapping
    public Salesman createSalesman(@RequestBody Salesman salesman) {
        return salesmanRepository.save(salesman);
    }
}

package pl.patrykmuskala.CrmApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.patrykmuskala.CrmApplication.Model.*;
import pl.patrykmuskala.CrmApplication.Repository.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserService {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/id={id}")
    public Optional<User> getUserById(@PathVariable(value = "id") int id) {
        return userRepository.findById(id);
    }

    @GetMapping("/name={name}")
    public Iterable<User> getUsersByName(@PathVariable(value = "name") String name) {
        return userRepository.findAllByName(name);
    }

    @GetMapping("/surname={surname}")
    public Iterable<User> getUsersBySurname(@PathVariable(value = "surname") String surname) {
        return userRepository.findAllBySurname(surname);
    }

    @GetMapping("/role={role}")
    public Iterable<User> getUsersByRole_Name(@PathVariable(value = "role") String role) {
        return userRepository.findAllByRole_Name(role);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}

package pl.patrykmuskala.CrmApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.patrykmuskala.CrmApplication.DTO.RegisterUserRequest;
import pl.patrykmuskala.CrmApplication.Model.*;
import pl.patrykmuskala.CrmApplication.Repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


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

    @PostMapping
    public User registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        User user = new User(registerUserRequest.getName(), passwordEncoder.encode(registerUserRequest.getPassword()), registerUserRequest.getUsername(), registerUserRequest.getRoles());
        return userRepository.save(user);
    }
}

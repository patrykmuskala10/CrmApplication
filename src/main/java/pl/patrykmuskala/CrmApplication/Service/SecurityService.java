package pl.patrykmuskala.CrmApplication.Service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import pl.patrykmuskala.CrmApplication.DTO.AuthenticationRequest;
import pl.patrykmuskala.CrmApplication.DTO.AuthenticationResponse;
import pl.patrykmuskala.CrmApplication.Model.User;
import pl.patrykmuskala.CrmApplication.Repository.UserRepository;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth/login")
public class SecurityService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;

    @Value("${secret.key}")
    private String KEY;

    @GetMapping
    public String test() {
        return "/auth/login (GET method)";
    }

    @PostMapping
    public ResponseEntity signup(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
            User user = (User) authentication.getPrincipal();
            Algorithm algorithm = Algorithm.HMAC256(KEY);
            String token = JWT.create()
                    .withSubject(user.getUsername())
                    .withIssuer("CRM")
                    .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                    .sign(algorithm);
            AuthenticationResponse authenticationResponse = new AuthenticationResponse(user.getUsername(), token);
            return ResponseEntity.ok(authenticationResponse);

        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}

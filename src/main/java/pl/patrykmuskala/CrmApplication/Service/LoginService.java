//package pl.patrykmuskala.CrmApplication.Service;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.web.bind.annotation.*;
//import pl.patrykmuskala.CrmApplication.Security.AppUser;
//
//import java.util.Date;
//
//@RestController
//@RequestMapping("/login2")
//
//public class LoginService {
//
//    @PostMapping
//    public String getToken(@RequestBody AppUser appUser){
//
//        Long currentTime = System.currentTimeMillis();
//        System.out.println("posttest");
//        return Jwts.builder()
//                .setSubject(appUser.getLogin())
//                .claim("roles", "BO")
//                .setIssuedAt(new Date((currentTime)))
//                .setExpiration(new Date((currentTime + 60000)))
//                .signWith(SignatureAlgorithm.HS256, appUser.getPassword())
//                .compact();
//    }
//
//    @GetMapping
//    public String LogInGet(){
//        return "test";
//    }
//}

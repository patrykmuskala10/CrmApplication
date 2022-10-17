package pl.patrykmuskala.CrmApplication.DTO;

import pl.patrykmuskala.CrmApplication.Model.Role;

import java.util.HashSet;
import java.util.Set;

public class RegisterUserRequest {

    private String name;
    private String password;
    private String username;

    private Set<Role> roles = new HashSet<>();

    public RegisterUserRequest() {
    }

    public RegisterUserRequest(String name, String password, String username, Set<Role> roles) {
        this.name = name;
        this.password = password;
        this.username = username;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

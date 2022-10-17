package pl.patrykmuskala.CrmApplication.DTO;

public class AuthenticationResponse {
    private String username;
    private String token;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void getToken(String token) {
        this.token = token;
    }
}

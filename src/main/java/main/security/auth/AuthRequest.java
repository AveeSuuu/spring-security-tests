package main.security.auth;

public record AuthRequest(
    String username,
    String password
) {

}

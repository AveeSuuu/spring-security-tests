package main.security.auth;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class UserRepository {
  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  private final List<UserDetails> APPLICATION_USERS = Arrays.asList(
      new User("admin", "admin123",
          Collections.singleton(new SimpleGrantedAuthority("ADMIN_ROLE")))
      //można pododawać więcej
  );

  public List<UserDetails> getApplicationUsers() {
    return APPLICATION_USERS;
  }

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info("[REPO] Received  request to load user by username: {}", username);
    return APPLICATION_USERS.stream()
        .filter(u -> u.getUsername().equals(username))
        .findFirst().orElseThrow(() ->
            new UsernameNotFoundException("User " + username + " not found"));
  }
}

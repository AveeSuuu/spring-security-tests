package main.security.userData;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user_data")
public class UserData implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  UUID userId;

  String userLogin;
  String userPassword;

  public UserData() {
  }

  public UserData(String login, String password) {
    userLogin = login;
    userPassword = password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of();
  }

  @Override
  public String getUsername() {
    return userLogin;
  }

  @Override
  public String getPassword() {
    return userPassword;
  }
}

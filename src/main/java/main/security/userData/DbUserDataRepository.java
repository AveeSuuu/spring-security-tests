package main.security.userData;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DbUserDataRepository implements UserDataRepository {

  private final JpaUserDataRepository userDataRepository;

  public UserData loadUserByUsername(String username) {
    return userDataRepository.findByUserLogin(username);
  }

  @Override
  public UserData saveUserDetails(UserData userData) {
    return userDataRepository.save(userData);
  }

  @Override
  public Boolean existsByUsername(String username) {
    return userDataRepository.existsByUserLogin(username);
  }
}

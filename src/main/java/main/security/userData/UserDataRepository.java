package main.security.userData;

public interface UserDataRepository {
  UserData loadUserByUsername(String username);
  UserData saveUserDetails(UserData userData);
  Boolean existsByUsername(String username);
}
package main.security.userData;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserDataRepository extends JpaRepository<UserData, UUID> {
  UserData findByUserLogin(String userLogin);
  Boolean existsByUserLogin(String userLogin);
}

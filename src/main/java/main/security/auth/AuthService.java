package main.security.auth;

import lombok.RequiredArgsConstructor;
import main.security.config.JwtUtils;
import main.security.userData.UserAlreadyExistsException;
import main.security.userData.UserData;
import main.security.userData.UserDataRepository;
import main.security.userData.UserNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final AuthenticationManager authenticationManager;
  private final BCryptPasswordEncoder encoder;
  private final UserDataRepository userDataRepository;
  private final JwtUtils jwtUtils;

  public String authenticateUserRequest(AuthRequest request) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        request.username(), request.password()
    ));

    final var user = userDataRepository.loadUserByUsername(request.username());
    if (user == null) {
      throw new UserNotFoundException(request.username());
    }

    return jwtUtils.generateToken(user);
  }

  public UserData registerNewUser(AuthRequest request) {
    if (Boolean.TRUE.equals(userDataRepository.existsByUsername(request.username()))) {
      throw new UserAlreadyExistsException(request.username());
    }

    var userdata = new UserData(
        request.username(),
        encoder.encode(request.password()));

    return userDataRepository.saveUserDetails(userdata);
  }
}

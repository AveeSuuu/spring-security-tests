package main.security.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.security.config.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final UserRepository userRepository;
  private final JwtUtils jwtUtils;

  @GetMapping
  public ResponseEntity<String> authenticate(@RequestBody AuthRequest request) {
    log.info("[CONTROLLER] Received  request to authenticate user: {}", request);
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        request.username(), request.password()
    ));
    log.info("[CONTROLLER] Authenticated user: {}", request.username());

    final var user = userRepository.loadUserByUsername(request.username());
    if (user == null) {
      return ResponseEntity.badRequest().body("Error: user not found");
    }

    return ResponseEntity.ok(jwtUtils.generateToken(user));
  }

}

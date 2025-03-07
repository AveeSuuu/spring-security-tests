package main.security.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.security.userData.UserData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @GetMapping
  public ResponseEntity<String> authenticate(@RequestBody AuthRequest request) {
    log.info("[CONTROLLER] Received request to authenticate user: {}", request);
    return ResponseEntity.ok(authService.authenticateUserRequest(request));
  }

  @PostMapping
  public ResponseEntity<UserData> registerNewUser(@RequestBody AuthRequest request) {
    log.info("[CONTROLLER] Received request to register new user: {}", request);
    var newUser = authService.registerNewUser(request);
    return ResponseEntity.ok(newUser);
  }
}

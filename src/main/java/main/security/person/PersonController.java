package main.security.person;

import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/people")
@AllArgsConstructor
public class PersonController {

  private final PersonService personService;

  @GetMapping
  public ResponseEntity<Iterable<Person>> getAllPeople() {
    return ResponseEntity.ok(personService.getAllPeople());
  }

  @GetMapping("/{personId}")
  public ResponseEntity<Person> getPersonById(@PathVariable UUID personId) {
    return ResponseEntity.ok(personService.getPersonById(personId));
  }
}

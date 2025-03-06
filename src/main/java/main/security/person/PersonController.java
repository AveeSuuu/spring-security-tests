package main.security.person;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/people")
@AllArgsConstructor
public class PersonController {
  private final PersonRepository personRepository;

  @GetMapping
  public ResponseEntity<Iterable<Person>> getAllPeople() {
    var people = personRepository.findAll();
    return  ResponseEntity.ok(people);
  }
}

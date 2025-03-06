package main.security.person;

import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonService {

  private final PersonRepository personRepository;

  public Iterable<Person> getAllPeople() {
    return personRepository.findAll();
  }

  public Person getPersonById(UUID personId) {
    return personRepository.findById(personId)
        .orElseThrow(() -> new PersonNotFoundException(personId));
  }
}

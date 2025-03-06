package main.security.person;

import java.util.UUID;

public class PersonNotFoundException extends RuntimeException {
  public PersonNotFoundException(UUID personId) {
    super(String.format("Person with id %s not found", personId));
  }
}

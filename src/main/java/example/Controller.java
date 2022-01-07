package example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  private final UserRepositoryImpl repository;

  @Autowired
  public Controller(final UserRepositoryImpl repository) {
    this.repository = repository;
  }

  @RequestMapping(
      method = RequestMethod.GET,
      path = "/users",
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<List<User>> get() {
    final List users = repository.getUsers();
    return ResponseEntity.ok(users);
  }

  @RequestMapping(
      method = RequestMethod.POST,
      path = "/users",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<User> create(@RequestBody User user) {
    repository.save(user);
    return ResponseEntity.ok(user);
  }
}

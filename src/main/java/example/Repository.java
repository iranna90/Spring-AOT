package example;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<User, String> {

  @Query("SELECT u FROM User where u.firstName=:firstName")
  Optional<User> findByName(String firstName);
}

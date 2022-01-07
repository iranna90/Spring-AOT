package example;

import java.util.List;

public interface UserRepository {
  List getUsers();

  void save(User user);
}

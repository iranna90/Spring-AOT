package example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class UserRepositoryImpl implements UserRepository {
  private final EntityManager entityManager;

  public UserRepositoryImpl(final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public List getUsers() {
    final Query query = entityManager.createQuery("SELECT u FROM User u");
    return query.getResultList();
  }

  @Override
  public void save(final User user) {
    final EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    entityManager.persist(user);
    transaction.commit();
  }
}

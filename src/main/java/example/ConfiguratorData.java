package example;

import java.util.Objects;
import java.util.Properties;

import javax.persistence.EntityManager;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class ConfiguratorData {

  @Bean
  public ImplicitNamingStrategyJpaCompliantImpl implicitNamingStrategyJpaCompliant() {
    return new ImplicitNamingStrategyJpaCompliantImpl();
  }

  @Bean
  public UserRepositoryImpl userRepository() {

    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setMaximumPoolSize(10);
    dataSource.setMinimumIdle(10);
    dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres?stringtype=unspecified&readOnly=true");
    dataSource.setUsername("postgres");
    dataSource.setPassword("mysecretpassword");
    dataSource.setAutoCommit(false);

    LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
    lef.setDataSource(dataSource);
    HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
    hibernateJpaVendorAdapter.setGenerateDdl(false);
    hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
    lef.setJpaVendorAdapter(hibernateJpaVendorAdapter);
    lef.setPackagesToScan("example");
    Properties jpaProperties = new Properties();
    jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
    jpaProperties.setProperty("hibernate.show_sql", "false");
    jpaProperties.setProperty("hibernate.format_sql", "false");
    jpaProperties.setProperty("hibernate.cache.use_second_level_cache", "false");
    jpaProperties.setProperty("hibernate.cache.use_query_cache", "false");
    jpaProperties.setProperty("hibernate.cache.use_query_cache", "false");
    jpaProperties.setProperty("spring.datasource.url", "jdbc:postgresql://localhost:5432/postgres?stringtype=unspecified&readOnly=true");
    lef.setJpaProperties(jpaProperties);
    lef.afterPropertiesSet();
    final EntityManager entityManager = Objects.requireNonNull(lef.getObject()).createEntityManager();
    return new UserRepositoryImpl(entityManager);
  }
}

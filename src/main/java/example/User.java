package example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user_data")
public class User {
  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Id
  @Column(name = "email")
  private String email;

  @JsonCreator
  public User(@JsonProperty("first_name") final String firstName,
              @JsonProperty("last_name") final String lastName,
              @JsonProperty("email") final String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  protected User(){
    // database
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }
}

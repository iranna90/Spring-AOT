package example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@ENti
public class User {
  private final String firstName;
  private final String lastName;
  private final String email;

  @JsonCreator
  public User(@JsonProperty("first_name") final String firstName,
              @JsonProperty("last_name") final String lastName,
              @JsonProperty("email") final String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
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

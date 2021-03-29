package test.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class UserDto {
    String firstName;
    String lastName;
    String address;


    @JsonCreator
    public UserDto(@JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("address") String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
}

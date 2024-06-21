package springbootrestfulapi.springbootrestfulapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotEmpty(message = "first name not to be null or empty")
    private String firstName;
    @NotEmpty(message = "last name not to be null or empty")
    private String lastName;
    @NotEmpty(message = "email not to be null or empty")
    @Email(message = "email not validate format.")
    private String email;
}

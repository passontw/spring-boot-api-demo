package springbootrestfulapi.springbootrestfulapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDto Model Information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @Schema(
            defaultValue = "test001",
            description = "User FirstName"
    )
    @NotEmpty(message = "first name not to be null or empty")
    private String firstName;
    @Schema(
            defaultValue = "test001",
            description = "User LastName"
    )
    @NotEmpty(message = "last name not to be null or empty")
    private String lastName;
    @Schema(
            defaultValue = "test001@aaa.com",
            description = "User Email"
    )
    @NotEmpty(message = "email not to be null or empty")
    @Email(message = "email not validate format.")
    private String email;
}

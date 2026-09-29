package com.codewithlei.JobTracker.users.dto.newUser;

import com.codewithlei.JobTracker.users.enums.AccountType;
import com.codewithlei.JobTracker.users.enums.Roles;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class RequestNewUserDTO {

    @NotBlank(message = "Must include a username")
    @Size(min = 3 , max = 50  , message = "Username must be between 3 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z0-9._-]+$", message = "Username can only contain letters, numbers, dots, hyphens, or underscores")
    private String username;

    @NotBlank(message = "Must include a firstname")
    @Size(max = 50 , message = "First name cannot exceed 50 characters")
    private String firstname;

    @NotBlank(message = "Must include a lastname")
    @Size(max = 50 , message = "Last name cannot exceed 50 characters")
    private String lastname;

    @NotBlank(message = "Must include an email")
    @Email(message = "Invalid email format")
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character (@$!%*?&)"
    )
    private String password;

    @NotNull(message = "Account type is required")
    private AccountType accountType;
}

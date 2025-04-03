package com.culinario.application.user.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    @Email
    @NotBlank
    @Size(max = 255, message = "name must have 255 characters at max")
    private String email;

    @NotBlank
    @Size(min = 8, max = 100, message = "password must have a minimum of 8 characters and a maximum of 100")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[^\\n]*$", message = "invalid password")
    private String password;

}

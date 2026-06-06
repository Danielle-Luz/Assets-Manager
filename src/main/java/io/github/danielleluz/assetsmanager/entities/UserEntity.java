package io.github.danielleluz.assetsmanager.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.context.annotation.Profile;

import java.util.UUID;

@Entity
public class UserEntity {
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Min(8)
    @Pattern(regexp = "^(?=.*[a-z]+)(?=.*[A-Z]+)(?=.*[^0-9a-zA-Z]+)(?=.*[0-9]+).+$") // contains one or more lower case characters, one or more upper case characters, one or more symbols and one or more numbers
    private String password;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$") // contains only one or more letters
    private String firstName;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String lastName;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}

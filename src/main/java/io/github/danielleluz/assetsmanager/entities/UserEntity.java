package io.github.danielleluz.assetsmanager.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Email
    @Column(unique = true)
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

    @ManyToMany(mappedBy = "users")
    private List<GroupEntity> groups;
}

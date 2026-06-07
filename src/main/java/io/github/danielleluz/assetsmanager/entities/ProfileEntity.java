package io.github.danielleluz.assetsmanager.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileEntity {
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Column(unique = true)
    private String profileName;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<PermissionEntity> permissions;
}

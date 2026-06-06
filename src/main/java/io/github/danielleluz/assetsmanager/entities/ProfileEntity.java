package io.github.danielleluz.assetsmanager.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
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
    private String profileName;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<PermissionEntity> permissions;
}

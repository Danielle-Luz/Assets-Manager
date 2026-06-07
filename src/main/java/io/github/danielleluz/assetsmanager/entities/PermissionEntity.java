package io.github.danielleluz.assetsmanager.entities;

import io.github.danielleluz.assetsmanager.enums.TableNameEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private TableNameEnum tableName;

    @NotNull
    private boolean create;

    @NotNull
    private boolean update;

    @NotNull
    private boolean read;

    @NotNull
    private boolean delete;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;
}

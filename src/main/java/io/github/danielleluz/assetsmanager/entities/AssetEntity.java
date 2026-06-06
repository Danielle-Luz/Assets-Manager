package io.github.danielleluz.assetsmanager.entities;

import io.github.danielleluz.assetsmanager.enums.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetEntity {
    @GeneratedValue
    private UUID id;

    @NotBlank
    private String productCode;

    @NotBlank
    private String serialNumber;

    @NotBlank
    private StatusEnum status;
}

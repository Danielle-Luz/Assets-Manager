package io.github.danielleluz.assetsmanager.entities;

import io.github.danielleluz.assetsmanager.enums.StatusEnum;
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
public class AssetEntity {
    @GeneratedValue
    private UUID id;

    @NotBlank
    private String productCode;

    @NotBlank
    private String serialNumber;

    @NotBlank
    private StatusEnum status;

    @ManyToMany
    @JoinTable(
            name = "asset_attachments",
            joinColumns = @JoinColumn(name = "asset_id"),
            inverseJoinColumns = @JoinColumn(name = "attachment_id")
    )
    private List<AttachmentEntity> attachments;
}

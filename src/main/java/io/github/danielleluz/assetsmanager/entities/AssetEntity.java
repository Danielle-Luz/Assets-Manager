package io.github.danielleluz.assetsmanager.entities;

import io.github.danielleluz.assetsmanager.enums.AssetStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    private String productCode;

    @NotBlank
    @Column(unique = true)
    private String serialNumber;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private AssetStatusEnum status = AssetStatusEnum.AVAILABLE;

    @ManyToMany
    @JoinTable(
            name = "asset_attachments",
            joinColumns = @JoinColumn(name = "asset_id"),
            inverseJoinColumns = @JoinColumn(name = "attachment_id")
    )
    private List<AttachmentEntity> attachments;

    @OneToMany(mappedBy = "asset_id")
    private List<AgreementAssetEntity> agreementAssets;

    @Transient
    public List<AgreementEntity> getAgreements() {
        return this.agreementAssets.
                stream().
                map(AgreementAssetEntity::getAgreement).
                collect(Collectors.toList());
    }
}

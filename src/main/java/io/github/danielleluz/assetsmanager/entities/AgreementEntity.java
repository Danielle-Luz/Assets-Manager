package io.github.danielleluz.assetsmanager.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AgreementEntity {
    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "moviment_type_id")
    private MovementTypeEntity movementType;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "current_step_id")
    private StepEntity currentStep;

    private String description;

    @CreatedDate
    private LocalDateTime creationDate;

    @LastModifiedDate
    private LocalDateTime lastModificationDate;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private UserEntity createdBy;

    @ManyToOne
    @JoinColumn(name = "last_modified_by_id")
    private UserEntity lastModifiedBy;

    @ManyToMany
    @JoinTable(
            name = "agreement_attachments",
            joinColumns = @JoinColumn(name = "agreement_id"),
            inverseJoinColumns = @JoinColumn(name = "attachment_id")
    )
    private List<AttachmentEntity> attachments;

    @OneToMany(mappedBy = "agreement_id")
    private List<AgreementAssetEntity> agreementAssets;

    @Transient
    public List<AssetEntity> getAssets() {
        return this.agreementAssets.
                stream().
                map(AgreementAssetEntity::getAsset).
                collect(Collectors.toList());
    }
}

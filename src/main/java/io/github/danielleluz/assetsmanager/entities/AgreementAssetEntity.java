package io.github.danielleluz.assetsmanager.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AgreementAssetEntity {
    @ManyToOne
    @JoinColumn(name = "agreement_id")
    private AgreementEntity agreement;

    @ManyToOne
    @JoinColumn(name = "asset_id")
    private AssetEntity asset;

    @CreatedDate
    @Column(updatable = false)
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdDate;
}

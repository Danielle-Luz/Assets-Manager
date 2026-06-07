package io.github.danielleluz.assetsmanager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private LocalDateTime createdDate;
}

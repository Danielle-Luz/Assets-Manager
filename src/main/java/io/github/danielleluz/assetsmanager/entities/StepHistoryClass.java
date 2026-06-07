package io.github.danielleluz.assetsmanager.entities;

import io.github.danielleluz.assetsmanager.enums.StepStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class StepHistoryClass {
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "step_action_id")
    @NotNull
    private StepActionEntity stepAction;

    @ManyToOne
    @JoinColumn(name = "agreement_id")
    private AgreementEntity agreement;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StepStatusEnum status = StepStatusEnum.PENDING;

    @CreatedDate
    private LocalDateTime creationDate;

    @LastModifiedDate
    private LocalDateTime lastModificationDate;

    @ManyToOne
    @JoinColumn(name = "answered_by_id")
    private UserEntity answeredBy;
}

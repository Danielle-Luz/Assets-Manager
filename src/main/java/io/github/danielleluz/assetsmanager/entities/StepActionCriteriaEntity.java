package io.github.danielleluz.assetsmanager.entities;

import io.github.danielleluz.assetsmanager.enums.OperatorEnum;
import io.github.danielleluz.assetsmanager.enums.ValueTypeEnum;
import io.github.danielleluz.assetsmanager.validation.annotations.IsValidClassField;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StepActionCriteriaEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @IsValidClassField(className = AgreementEntity.class)
    private String field;

    @NotBlank
    private OperatorEnum operator;

    @NotBlank
    private String value;

    @NotBlank
    private ValueTypeEnum valueType;
}

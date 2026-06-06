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
public class MovementTypeEntity {
    @GeneratedValue
    private UUID id;

    @NotBlank
    private String movementType;

    @OneToMany(mappedBy = "movementType", cascade = CascadeType.ALL)
    private List<StepEntity> steps;
}

package io.github.danielleluz.assetsmanager.entities;

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
public class MovementTypeEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private MovementTypeEntity movementType;

    @OneToMany(mappedBy = "movementType", cascade = CascadeType.ALL)
    private List<StepEntity> steps;
}

package io.github.danielleluz.assetsmanager.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StepEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Column(length = 40)
    @Size(max = 40)
    private String name;

    @NotBlank
    @Min(1)
    private int order;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "movement_type_id")
    private MovementTypeEntity movementType;

    @OneToMany(mappedBy = "step")
    private List<StepActionEntity> stepActions;
}

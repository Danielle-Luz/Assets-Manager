package io.github.danielleluz.assetsmanager.entities;

import io.github.danielleluz.assetsmanager.enums.StepActionEnum;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StepActionEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "step_id")
    private StepEntity step;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @Enumerated(EnumType.STRING)
    private StepActionEnum stepAction;
}

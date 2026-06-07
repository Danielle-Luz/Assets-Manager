package io.github.danielleluz.assetsmanager.enums;

import io.github.danielleluz.assetsmanager.entities.GroupEntity;
import io.github.danielleluz.assetsmanager.entities.StepHistoryClass;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

@Getter
@AllArgsConstructor
public enum StepActionEnum {
    SEND_EMAIL(null),
    SEND_APPROVAL_REQUEST(null),
    GENERATE_CONTRACT(null);

    private final Function<GroupEntity, StepHistoryClass> action;
}

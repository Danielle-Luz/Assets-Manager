package io.github.danielleluz.assetsmanager.validation.validators;

import io.github.danielleluz.assetsmanager.validation.annotations.IsValidClassField;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassFieldValidator implements ConstraintValidator<IsValidClassField, String> {

    private Class<?> className;

    @Override
    public void initialize(IsValidClassField constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.className = constraintAnnotation.className();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Set<String> fieldNames =
                Arrays.stream(className.getFields()).
                map(Field::getName).
                collect(Collectors.toSet());

        return fieldNames.contains(value);
    }
}

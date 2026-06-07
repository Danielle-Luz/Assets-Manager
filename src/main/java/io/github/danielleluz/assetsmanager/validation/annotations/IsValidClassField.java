package io.github.danielleluz.assetsmanager.validation.annotations;

import io.github.danielleluz.assetsmanager.validation.validators.ClassFieldValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ClassFieldValidator.class)
public @interface IsValidClassField {
    Class<?> className();

    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

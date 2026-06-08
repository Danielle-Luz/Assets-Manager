package io.github.danielleluz.assetsmanager.validation.annotations;

import io.github.danielleluz.assetsmanager.validation.validators.SameFieldTypeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SameFieldTypeValidator.class)
public @interface SameFieldType {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

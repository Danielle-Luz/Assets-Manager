package io.github.danielleluz.assetsmanager.validation.validators;

import io.github.danielleluz.assetsmanager.entities.AgreementEntity;
import io.github.danielleluz.assetsmanager.entities.StepActionCriteriaEntity;
import io.github.danielleluz.assetsmanager.validation.annotations.SameFieldType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.function.UnaryOperator;

public class SameFieldTypeValidator implements ConstraintValidator<SameFieldType, StepActionCriteriaEntity> {

    List<UnaryOperator<String>> getClassNameMethods = List.of(
            SameFieldTypeValidator::getDecimalClassNameIfDecimal,
            SameFieldTypeValidator::getIntegerClassNameIfInteger,
            SameFieldTypeValidator::getBooleanClassNameIfBoolean
    );

    @Override
    public boolean isValid(StepActionCriteriaEntity criteria, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        try {
            String criteriaFieldClassName =
                    AgreementEntity.class.
                    getField(criteria.getField()).
                    getType().
                    getName();

            String valueClassName =
                    this.getClassNameMethods.stream().
                            map(
                        classNameMethod ->
                                classNameMethod.apply(criteria.getValue())
                            ).
                            filter(Objects::nonNull).
                            findFirst().
                            orElse(String.class.getName());

            boolean hasSameType = criteriaFieldClassName.equals(valueClassName);

            if (!hasSameType) {
                context.buildConstraintViolationWithTemplate(
                    String.format(
                            "The field %s expects a value of type %s, the value passed is of type %s",
                            criteria.getField(),
                            criteriaFieldClassName,
                            valueClassName
                    )
                ).addPropertyNode("value").
                addConstraintViolation();
            }

            return hasSameType;
        } catch (NoSuchFieldException e) {
            context.buildConstraintViolationWithTemplate(
                String.format(
                    "There is no agreement field with name %s, relate a valid field to the criteria",
                    criteria.getField()
                )
            ).addPropertyNode("value")
            .addConstraintViolation();

            return false;
        }
    }

    private static String getIntegerClassNameIfInteger(String value) {
        try {
            Integer.parseInt(value);
            return Integer.class.getName();
        } catch (NumberFormatException | NullPointerException e) {
            return null;
        }
    }

    private static String getDecimalClassNameIfDecimal(String value) {
        try {
            new BigDecimal(value);
            return BigDecimal.class.getName();
        } catch (Exception e) {
            return null;
        }
    }

    private static String getBooleanClassNameIfBoolean(String value) {
        try {
            boolean isBoolean = value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false");

            if (isBoolean) return Boolean.class.getName();

            throw new Exception();
        } catch (Exception e) {
            return null;
        }
    }
}

package com.smozely.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Represents an Email Address. Instead of just passing strings around this ensures the value is a valid email on creation.
 */
public class EmailAddress {

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    private static final Validator validator;

    @Email
    @NotEmpty
    private final String email;

    public EmailAddress(String email) {
        this.email = email;

        Set<ConstraintViolation<EmailAddress>> violations = validator.validate(this);
        if (violations.size() > 0) {
            throw new ConstraintViolationException(violations);
        }
    }
}

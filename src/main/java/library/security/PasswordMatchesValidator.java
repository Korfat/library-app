package library.security;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import library.dto.UserRegistrationDto;
import library.security.annotations.PasswordMatches;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        UserRegistrationDto user = (UserRegistrationDto) obj;
        return user.getPassword().equals(user.getRepeatPassword());
    }
}

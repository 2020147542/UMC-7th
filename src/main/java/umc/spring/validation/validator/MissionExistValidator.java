package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiResponse.code.status.ErrorStatus;
import umc.spring.repository.MissionRepository;
import umc.spring.validation.annotation.ExistStore;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistStore, Long> {

    private final MissionRepository missionRepository;

    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = missionRepository.existsById(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUNT.toString()).addConstraintViolation();
        }

        return isValid;
    }
}

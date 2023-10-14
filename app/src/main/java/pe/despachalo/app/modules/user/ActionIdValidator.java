package pe.despachalo.app.modules.user;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActionIdValidator implements ConstraintValidator<ActionId, String> {

  private final ValidateActionIdService validateActionIdService;

  @Override
  public void initialize(ActionId constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (StringUtils.isBlank(value)) {
      return true;
    }

    return validateActionIdService.execute(value);
  }
}

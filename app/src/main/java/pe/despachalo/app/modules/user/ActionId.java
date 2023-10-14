package pe.despachalo.app.modules.user;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ActionIdValidator.class})
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionId {
  String message() default "Must be a valid action ID, request all actions by module to know the valid ones.";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}

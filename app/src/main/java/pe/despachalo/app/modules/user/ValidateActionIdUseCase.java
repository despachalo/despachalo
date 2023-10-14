package pe.despachalo.app.modules.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.despachalo.app.modules.common.hexagonal.UseCase;
import pe.despachalo.app.modules.user.ports.ValidateActionIdPort;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class ValidateActionIdUseCase implements ValidateActionIdService {
  private final ValidateActionIdPort validateActionIdPort;

  @Override
  public boolean execute(String actionId) {
    return validateActionIdPort.validate(actionId);
  }
}

package pe.despachalo.app.modules.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.despachalo.app.modules.common.hexagonal.UseCase;
import pe.despachalo.app.modules.user.domain.UserRole;
import pe.despachalo.app.modules.user.domain.UserRoleToRegister;
import reactor.core.publisher.Mono;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class RegisterUserRoleUseCase implements RegisterUserRoleService {

  @Override
  public Mono<UserRole> execute(UserRoleToRegister roleToRegister) {
    // valid if user has permissions for this action

    // validate name must be unique
    return null;
  }
}

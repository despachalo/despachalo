package pe.despachalo.app.modules.user;

import pe.despachalo.app.modules.user.domain.UserRole;
import pe.despachalo.app.modules.user.domain.UserRoleToRegister;
import reactor.core.publisher.Mono;

public interface RegisterUserRoleService {
  Mono<UserRole> execute(UserRoleToRegister roleToRegister);
}

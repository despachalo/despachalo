package pe.despachalo.app.modules.user;

import pe.despachalo.app.modules.user.domain.ModuleWithActions;
import reactor.core.publisher.Flux;

public interface GetAllActionsByModuleService {
  Flux<ModuleWithActions> execute();
}

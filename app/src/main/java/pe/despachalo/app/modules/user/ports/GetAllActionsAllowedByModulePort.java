package pe.despachalo.app.modules.user.ports;

import pe.despachalo.app.modules.user.domain.ModuleWithActions;
import reactor.core.publisher.Flux;

public interface GetAllActionsAllowedByModulePort {
  Flux<ModuleWithActions> getAllByModule();
}

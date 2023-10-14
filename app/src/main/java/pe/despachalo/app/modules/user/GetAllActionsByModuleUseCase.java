package pe.despachalo.app.modules.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.despachalo.app.modules.common.hexagonal.UseCase;
import pe.despachalo.app.modules.user.domain.ModuleWithActions;
import pe.despachalo.app.modules.user.ports.GetAllActionsAllowedByModulePort;
import reactor.core.publisher.Flux;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class GetAllActionsByModuleUseCase implements GetAllActionsByModuleService {

  private final GetAllActionsAllowedByModulePort getAllActionsAllowedByModulePort;

  @Override
  public Flux<ModuleWithActions> execute() {
    return getAllActionsAllowedByModulePort.getAllByModule();
  }
}

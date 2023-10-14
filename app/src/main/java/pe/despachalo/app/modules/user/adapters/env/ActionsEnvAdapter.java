package pe.despachalo.app.modules.user.adapters.env;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.despachalo.app.modules.common.hexagonal.EnvAdapter;
import pe.despachalo.app.modules.user.domain.ModuleWithActions;
import pe.despachalo.app.modules.user.ports.GetAllActionsAllowedByModulePort;
import pe.despachalo.app.modules.user.ports.ValidActionIdPort;
import reactor.core.publisher.Flux;

import java.util.Collection;


@Slf4j
@EnvAdapter
@RequiredArgsConstructor
public class ActionsEnvAdapter implements
    ValidActionIdPort,
    GetAllActionsAllowedByModulePort {

  private final PermissionProps permissionProps;
  private final ModulesMapper modulesMapper;

  @Override
  public boolean valid(String actionId) {
    return permissionProps.allModules()
        .stream()
        .map(PermissionProps.Module::getActions)
        .flatMap(Collection::stream)
        .map(PermissionProps.Action::getId)
        .anyMatch(id -> id.equals(actionId));
  }

  @Override
  public Flux<ModuleWithActions> getAllByModule() {
    var modules = permissionProps.allModules()
        .stream()
        .map(modulesMapper::toModuleWithActions);

    return Flux.fromStream(modules);
  }
}
